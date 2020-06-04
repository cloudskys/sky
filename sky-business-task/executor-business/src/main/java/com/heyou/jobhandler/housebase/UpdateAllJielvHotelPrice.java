package com.heyou.jobhandler.housebase;

import com.heyou.entity.housebase.vo.JielvSourceData;
import com.heyou.service.housebase.IJielvSourceDataService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/3/30 17:25
 * @Version: 1.0
 */
@JobHandler(value = "updateAllJielvHotelPrice")
@Component
public class UpdateAllJielvHotelPrice  extends IJobHandler {

    @Autowired
    private IJielvSourceDataService jielvSourceDataService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        List<Integer> list = jielvSourceDataService.getAllJielvHotelId();
        ExecutorService excutor = Executors.newFixedThreadPool(10);
        // 定义递增条数
        int countNum = 0;
        if(null != list && list.size() > 0 ){
            long start = System.currentTimeMillis();
            for (int i = 0 ; i< list.size() ; i ++){
                // 判断当前空闲线程数量
                while (((ThreadPoolExecutor)excutor).getActiveCount()>9){
                    Thread.sleep(200);
                }
                //因为第三方报价接口又qps限制，所以每分钟限制跑700条
                if(countNum == 700){
                    long end = System.currentTimeMillis();
                    long value = end - start;
                    if(value < 60000){
                        //System.out.println("开始时间"+start+",结束时间"+end+",差值"+value+",----休息"+(60000-value));
                        Thread.sleep(60000-value);
                    }
                    countNum = 0;
                    start = System.currentTimeMillis();
                }else{
                    countNum ++ ;
                }
                // 查询主键id
                Integer sourceId =  jielvSourceDataService.getIdByHotelId(list.get(i));
                System.out.println("hotelId_"+list.get(i)+"||source_"+sourceId);
                excutor.execute(new InitHotelInfo(list.get(i),sourceId,1));
            }
        }
        return null;
    }



    public class InitHotelInfo implements Runnable{
        private Integer id;
        private Integer sourceId;
        private Integer type;
        public InitHotelInfo(Integer id, Integer sourceId, Integer type){
            this.id = id;
            this.sourceId = sourceId;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                updateAllHotelPrice(id,sourceId,type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateAllHotelPrice(Integer id, Integer sourceId, Integer type){
        try {
            Map<String,Object> resultMap = jielvSourceDataService.getHotelPrice(id);
            if(resultMap !=null && resultMap.size() > 0){
                JielvSourceData sourceData = new JielvSourceData();
                sourceData.setUpdateTime(new Date());
                sourceData.setState(0);
                sourceData.setHotelId(id);
                sourceData.setId(sourceId);
                sourceData.setType(type);
                if(resultMap.get("rooms") !=null){
                    sourceData.setRoomRatePlan((String) resultMap.get("rooms"));
                }
                if(resultMap.get("bookingRules") !=null){
                    sourceData.setBookingRules((String) resultMap.get("bookingRules"));
                }
                if(resultMap.get("refundRules") !=null){
                    sourceData.setRefundRules((String) resultMap.get("refundRules"));
                }
                jielvSourceDataService.updateSourceDate(sourceData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
