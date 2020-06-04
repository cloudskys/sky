package com.heyou.jobhandler.housebase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.heyou.entity.housebase.vo.JielvHotelInfoVO;
import com.heyou.service.housebase.IJielvInfoService;
import com.heyou.service.housebase.IJielvSourceDataService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/1/5 15:01
 * @Version: 1.0
 */
@JobHandler(value = "initJielvHotelHandler")
@Component
public class InitJielvHotelHandler extends IJobHandler {

    @Autowired
    private IJielvSourceDataService jielvSourceDataService;
    @Autowired
    private IJielvInfoService jielvInfoService;

    @Override
    public ReturnT<String> execute(String ...param) {
        //param 分页不能为空
        if (StringUtils.isBlank(param[1])){
            ReturnT<String> fail = FAIL;
            fail.setMsg("分页不能为空");
            return fail;
        }

        //TODO 参数获取
        String[] params = param[1].split(",");
        String pageNo = params[0];
        String isConfirm = params[1];
        Integer pageNum = (Integer.valueOf(pageNo)-1)*50 + 1;

        int endNum = pageNum+50;
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = pageNum ; i < endNum  ;i++){
            request(executorService,i,isConfirm);
        }
        long end = System.currentTimeMillis();
        System.out.println("初始化数据一共使用："+( end - start )/1000 +"秒");
        return SUCCESS;
    }

    public ReturnT<String> request(ExecutorService executorService,int pageNo,String isConfirm){
        String result = jielvInfoService.getHotelInfoList(pageNo,isConfirm);
        if(StringUtils.isNotBlank(result)){
            JSONObject jsonObject = JSONObject.fromObject(result);
            int code = jsonObject.getInt("code");
            if(code == 0){
                jsonObject = jsonObject.getJSONObject("result");
                String jsonArrayStr = jsonObject.getString("hotels");
                List<JielvHotelInfoVO> list = JSON.parseObject(jsonArrayStr,new TypeReference<ArrayList<JielvHotelInfoVO>>(){});
                for(JielvHotelInfoVO hotelInfoVO : list){
                    //获取酒店房型，图片，等
                    Integer sourceId =  jielvSourceDataService.getIdByHotelId(hotelInfoVO.getHotelId());
                    //获取酒店详细信息并入库
                    executorService.execute(new InitSourceInfo(hotelInfoVO.getHotelId(),sourceId,0));
                }
            }else{
                ReturnT<String> fail = FAIL;
                fail.setMsg("code="+jsonObject.getInt("code")+",message:"+jsonObject.getString("errorMsg"));
                return fail;
            }

        }
        return SUCCESS;
    }

    public class InitSourceInfo implements Runnable{
        private Integer hotelId;
        private Integer sourceId;
        private Integer type;

        public InitSourceInfo(Integer hotelId,Integer sourceId,Integer type){
            this.hotelId = hotelId;
            this.sourceId = sourceId;
            this.type = type;
        }

        @Override
        public void run() {
            System.out.println("hotelId_"+hotelId+"||source_"+sourceId);
            jielvSourceDataService.getHotelDetailInfo(hotelId,sourceId,type);
        }
    }

}
