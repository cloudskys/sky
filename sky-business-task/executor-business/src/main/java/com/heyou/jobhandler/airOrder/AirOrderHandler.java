package com.heyou.jobhandler.airOrder;

import com.heyou.entity.airOrder.AirOrderInfoVo;
import com.heyou.service.airOrder.IAirTicketService;
import com.heyou.util.Contants;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/7/25 17:52
 * @Version: 1.0
 */
@JobHandler(value = "airOrderCancelHandler")
@Component
public class AirOrderHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IAirTicketService airTicketService;
    @Resource(name = "rabbitTemplateMessage")
    private RabbitTemplate rabbitTemplate;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        logger.info("======================取消订单接口开始执行");
        List<AirOrderInfoVo> orderNoList = airTicketService.getWaitCancelOrderNo();
        for (AirOrderInfoVo airOrderInfoVo : orderNoList) {
            airTicketService.updateOrderState(airOrderInfoVo.getOrderNo());
            try {
                Map<String,Object> map = new HashMap<>();
                map.put("ticketType",1);
                map.put("orderNo",airOrderInfoVo.getOrderNo());
                map.put("airno",airOrderInfoVo.getFlightNo());
                map.put("flyStartDate",airOrderInfoVo.getDepTime());
                map.put("phone",airOrderInfoVo.getPhone());
                map.put("flyEndDate",airOrderInfoVo.getArrTime());
                map.put("startPort",airOrderInfoVo.getDepName());
                map.put("startCity",airOrderInfoVo.getDepCity());
                map.put("endPort",airOrderInfoVo.getArrName());
                map.put("endCity",airOrderInfoVo.getArrCity());
                map.put("airlineName",airOrderInfoVo.getAirlineName());
                // 出发航站楼
                map.put("depJetquay", airOrderInfoVo.getDepJetquay());
                // 到达航站楼
                map.put("arrJetquay", airOrderInfoVo.getArrJetquay());

                // 短息内容
                rabbitTemplate.convertAndSend(Contants.smsexchange,Contants.smsKey,map);
            } catch (AmqpException e) {
                logger.error("================订单定时取消异常、订单号："+airOrderInfoVo.getOrderNo());
                e.printStackTrace();
            }
        }

        return SUCCESS;
    }
}
