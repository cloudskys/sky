package com.heyou.listener.housebase;

import com.heyou.service.housebase.IJielvSourceDataService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/3/30 12:47
 * @Version: 1.0
 */
@Component("synchronizationJielvHotelInfoListener")
public class SynchronizationJielvHotelInfoListener implements MessageListener {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IJielvSourceDataService jielvSourceDataService;

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Integer> list = objectMapper.readValue(message.getBody(), ArrayList.class);
            if(null != list && list.size() >0 ){
                for (Integer hotelId:list) {
                    Integer sourceId =  jielvSourceDataService.getIdByHotelId(hotelId);
                    //获取酒店详细信息并入库
                    jielvSourceDataService.getHotelDetailInfo(hotelId,sourceId,0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
