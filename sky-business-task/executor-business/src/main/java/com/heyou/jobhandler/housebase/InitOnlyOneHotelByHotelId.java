package com.heyou.jobhandler.housebase;

import com.heyou.service.housebase.IJielvSourceDataService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

@JobHandler(value = "initOnlyOneHotelByHotelId")
@Component
public class InitOnlyOneHotelByHotelId extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IJielvSourceDataService jielvSourceDataService;

    @Override
    public ReturnT<String> execute(String... params){
        if (StringUtils.isBlank(params[1])){
            ReturnT<String> fail = FAIL;
            fail.setMsg("酒店id为空");
            return fail;
        }
        String[] hotelIdArray = params[1].split(",");
        for (String hotelId :hotelIdArray) {
            Integer sourceId = null;
            try {
                sourceId = jielvSourceDataService.getIdByHotelId(Integer.valueOf(hotelId));
                //获取酒店详细信息并入库
                jielvSourceDataService.getHotelDetailInfo(Integer.valueOf(hotelId),sourceId,0);
            } catch (NumberFormatException e) {
                logger.error("增加指定酒店异常:"+e.getMessage());
                e.printStackTrace();
            }
        }
        return SUCCESS;
    }



}
