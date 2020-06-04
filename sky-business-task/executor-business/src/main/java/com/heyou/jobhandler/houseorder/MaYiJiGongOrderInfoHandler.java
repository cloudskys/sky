package com.heyou.jobhandler.houseorder;

import com.heyou.entity.houseorder.po.InstallOrderInfo;
import com.heyou.service.houseorder.IInstallOrderService;
import com.heyou.util.Contants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/6/28 11:21
 * @Version: 1.0
 */
@JobHandler(value = "maYiJiGongOrderInfoHandler")
@Component
public class MaYiJiGongOrderInfoHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private IInstallOrderService installOrderService;
    @Resource(name = "amqpTemplate")
    private RabbitTemplate rabbitTemplate;


    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        try {
            //查询所有未完成的订单
            List<String> installOrder = installOrderService.getUnfinishedInstallOrder();
            if(null != installOrder && installOrder.size() > 0 ){
                int num = 30;
                //以30单未一个消息，计算循环次数
                BigDecimal size = BigDecimal.valueOf(installOrder.size()).divide(BigDecimal.valueOf(num),0, RoundingMode.UP);
                for (int i = 0 ; i < size.intValue() ; i ++){
                    int subStart = i * 30;
                    int subEnd = subStart + num;
                    if( (subStart+num) > installOrder.size() ){
                        subEnd = installOrder.size();
                    }
                    List<String> subList = installOrder.subList(subStart,subEnd);
                    //发mq
                    rabbitTemplate.convertAndSend(Contants.exchange,Contants.maYiJiGongOrderInfoKey,subList);
                    System.out.println(subList.size());
                }
            }
        } catch (Exception e) {
            logger.error("查询蚂蚁技工未完成订单失败："+e.getMessage());
            e.printStackTrace();
        }

        return null;
    }


}
