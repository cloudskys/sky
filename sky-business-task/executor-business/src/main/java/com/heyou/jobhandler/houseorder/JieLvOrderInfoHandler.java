package com.heyou.jobhandler.houseorder;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heyou.config.JieLvQueryOrderDetailConfig;
import com.heyou.config.JielvSystemConfig;
import com.heyou.dao.houseorder.ExceptionRecordDao;
import com.heyou.entity.houseorder.po.ExceptionRecord;
import com.heyou.entity.houseorder.po.OrderInfoPO;
import com.heyou.service.houseorder.IOrderInfoService;
import com.heyou.util.Contants;
import com.heyou.util.HttpClientGzip;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Description:
 * @Author: xs
 * @Time: 2019/1/17 15:00
 * @Version: 1.0
 */
@JobHandler(value = "jieLvOrderInfoHandler")
@Service
public class JieLvOrderInfoHandler extends IJobHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    @Resource(name = "amqpTemplate")
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IOrderInfoService orderInfoService;
    @Autowired
    private JielvSystemConfig jielvSystemConfig;
    @Autowired
    private JieLvQueryOrderDetailConfig jieLvQueryOrderDetailConfig;
    @Autowired
    private ExceptionRecordDao orderExcepLogDao;

    @Override
    public ReturnT<String> execute(String...param) throws Exception {

        List<OrderInfoPO> orderList =  orderInfoService.findAllWaitConfirmOrder();
        for(OrderInfoPO orderInfo: orderList){
            Map<String, Object> respMap = queryOrderDetail(orderInfo.getJieLvOrderCode(),orderInfo.getOrderNo(),
                orderInfo.getCreateBegin(), orderInfo.getCreateBegin());
            Integer code = (Integer) respMap.get("code");
            if(code!=0){
                ReturnT<String> fail = FAIL;
                fail.setMsg("code="+respMap.get("code")+",message:"+respMap.get("errorMsg"));
                continue;
            }else{
                JSONObject json = JSONObject.parseObject(respMap.get("result").toString());
                JSONArray jsonObjects =  JSONArray.parseArray(JSON.toJSONString(json.get("orderDetailList")));
                JSONObject orderJson = (JSONObject) jsonObjects.get(0);
                Integer orderStatus = orderJson.getInteger("orderStatus");
                Map<String,Object> map = new HashMap<>();
                map.put("orderNo",orderInfo.getOrderNo());
                map.put("orderStatus",orderStatus);
                // 捷旅订单状态为这三种（2:已确认、3:已拒单、4:已取消），发消息更新全球家订单状态
                if(orderStatus==2 || orderStatus==3 || orderStatus==4){
                    rabbitTemplate.convertAndSend(Contants.exchange,Contants.queryOrderKey,map);
                }
            }
        }
        return SUCCESS;
    }


    public Map<String,Object> queryOrderDetail(String orderCode, String customerOrderCode, Date createBegin, Date createEnd)
        throws Exception {
        String url = jieLvQueryOrderDetailConfig.getHostPort() + jieLvQueryOrderDetailConfig.getUrl();
        Map<String, Object> results = new HashMap<String, Object>();
        Map<String,Object> jsonMap = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        Map<String,Object> headMap = getJielvSystemParam();
        params.put("orderCode", orderCode);
        params.put("customerOrderCode", customerOrderCode);
//        params.put("createBegin", createBegin);
//        params.put("createEnd", createEnd);
        jsonMap.put("head",headMap);
        jsonMap.put("data",params);

        String retStr;
        try {
            retStr = HttpClientGzip.doGet("",url+ Contants.reqData+ JSON.toJSONString(jsonMap));
        } catch (Exception e) {
            logger.error("请求捷旅酒店查询订单详情超时或网络异常", e);
            ExceptionRecord exceptionRecord = new ExceptionRecord();
            exceptionRecord.setOrderNo(customerOrderCode);
            exceptionRecord.setExcepMsg("请求捷旅酒店查询订单详情超时或网络异常!");
            exceptionRecord.setCallMethod(url);
            exceptionRecord.setParams(JSON.toJSONString(jsonMap));
            exceptionRecord.setExcepSort("jielv");
            exceptionRecord.setReqMode("get");
            exceptionRecord.setLevel(2);
            exceptionRecord.setProcessState(0);
            exceptionRecord.setCreateTime(new Date());
            orderExcepLogDao.insertExceptionRecord(exceptionRecord);

            throw new Exception("请求捷旅酒店查询订单详情超时或网络异常");
        }
        JSONObject json = JSONObject.parseObject(retStr);
        Integer code = json.getInteger("code");
        String errorMsg = json.getString("errorMsg");
        results.put("code", code);
        results.put("msg", errorMsg);
        if(code==0){
            String result = json.getString("result");
            results.put("result", result);
        }
        return results;
    }

    public Map<String,Object> getJielvSystemParam(){
        String appkey = jielvSystemConfig.getAppkey();
        String secretKey = jielvSystemConfig.getSecretKey();
        long timestamp = System.currentTimeMillis()+1000*60*5;
        String version = jielvSystemConfig.getVersion();
        Map<String,Object> head = new HashMap<String, Object>();
        head.put("appKey",appkey);
        head.put("timestamp",timestamp);
        head.put("sign", getSign(appkey,secretKey,String.valueOf(timestamp)));
        head.put("version",version );
        return head;
    }

    public static String getSign(String appKey,String secretKey,String timestamp){
        StringBuilder md5Builder = new StringBuilder();
        md5Builder.append(secretKey).append(appKey);
        String key = DigestUtils.md5Hex(md5Builder.toString()).toLowerCase();
        String sing = DigestUtils.md5Hex(key+timestamp).toLowerCase();
        return  sing;
    }

}
