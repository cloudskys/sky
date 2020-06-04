package com.heyou.jobhandler.housebase;

import com.heyou.service.housebase.IJielvSourceDataService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/4/18 14:24
 * @Version: 1.0
 */
@JobHandler(value = "delNigthrilyRateInfo")
@Component
public class DelNightlyRateInfo extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());


    @Autowired
    private IJielvSourceDataService jielvSourceDataService;

    @Override
    public ReturnT<String> execute(String... params) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去 3天
        c.setTime(new Date());
        c.add(Calendar.DATE, -3);
        String delDete = format.format(c.getTime());
        int num = jielvSourceDataService.deleteObsoleteNightlyRate(delDete);
        logger.info("捷旅历史价格删除数量："+ num);
        return SUCCESS;
    }

}
