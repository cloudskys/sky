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
 * @Time: 2019/4/1 16:01
 * @Version: 1.0
 */
@JobHandler(value = "updateAllJielvHotelStaticInfo")
@Component
public class UpdateAllJielvHotelStaticInfo  extends IJobHandler {
    @Autowired
    private IJielvSourceDataService jielvSourceDataService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        List<Integer> list = jielvSourceDataService.getAllJielvHotelId();
        ExecutorService excutor = Executors.newFixedThreadPool(10);
        if(null != list && list.size() > 0 ){
            for (int i = 0 ; i< list.size() ; i ++){
                // 判断线程空闲数量
                while (((ThreadPoolExecutor)excutor).getActiveCount()>9){
                    Thread.sleep(200);
                }
                Integer sourceId =  jielvSourceDataService.getIdByHotelId(list.get(i));
                if(sourceId != null){
                    System.out.println("hotelId_"+list.get(i)+"||source_"+sourceId);
                    excutor.execute(new InitHotelInfo(list.get(i),sourceId,4));
                }
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
                jielvSourceDataService.initHotelStaticInfo(id,sourceId,type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
