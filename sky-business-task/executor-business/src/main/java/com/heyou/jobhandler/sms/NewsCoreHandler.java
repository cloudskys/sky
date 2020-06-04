package com.heyou.jobhandler.sms;

import com.heyou.Biz.NewsCoreServiceBiz;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @program: task
 * @description
 * @author: hjl
 * @create: 2020-03-11 15:31
 **/
@JobHandler(value = "newsCoreHandler")
@Component
public class NewsCoreHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private NewsCoreServiceBiz newsCoreServiceBiz;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Long start = System.currentTimeMillis();
        Long days = Long.valueOf(params[1]);
        LocalDate localDate = LocalDate.now();
        LocalDate date = localDate.minusDays(days);
        logger.info("============定时处理news_core【"+date.toString()+"】之前的数据为已读");
        int i = newsCoreServiceBiz.updateNewsCoreToInvalid(date.toString());
        Long end = System.currentTimeMillis();
        logger.info("============定时处理news_core【"+date.toString()+"】之前的数据为已读--处理完成，影响行数："+i+",耗时："+(end-start)+"ms");
        return ReturnT.SUCCESS;
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate date = localDate.minusDays(30);
        System.out.println(date.toString());
        long days = localDate.until(LocalDate.parse("2018-07-03"), ChronoUnit.DAYS);
        System.out.println(days);
    }
}
