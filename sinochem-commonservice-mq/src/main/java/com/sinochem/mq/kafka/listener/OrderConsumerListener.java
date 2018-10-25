package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsOrder;
import com.sinochem.order.api.feign.OrderFeignClient;
import com.sinochem.order.api.vo.OrderAuditReq;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sagacity.core.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @project sinochem
 * @description 订单相关消费监听者
 * @author zhanglei <a href="mailto:zhanglei79@sinochem.com">联系作者</a>
 * @version Revision:v1.0
 * @date 2018/8/13 17:35
 **/
@Component
public class OrderConsumerListener {
//    private final static Logger logger = LoggerFactory.getLogger(OrderConsumerListener.class);
//
//    @Resource
//    private OrderFeignClient orderFeignClient;
//
//    /**
//     * @Author zhanglei
//     * @Description
//     * @Date 2018/8/13 19:47
//     * @Param [record]
//     * @return void
//     **/
//    @KafkaListener(topics = WmsConstant.ORDER_STATUS_SYNC_TOPIC)
//    public void updateOrderAuditRst(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.debug("[订单] 订单审核结果报文：{}" + gson.toJson(record));
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                MsOrder msOrder = gson.fromJson(message.toString(), MsOrder.class);
//                OrderAuditReq orderAuditReq = new OrderAuditReq();
//                orderAuditReq.setOrderSn(msOrder.getOrderSn());
//                orderAuditReq.setAuditStatus(msOrder.getOrderStatus());
//                orderAuditReq.setAuditBy(msOrder.getCreatedBy());
//                orderAuditReq.setBalancePrice(new BigDecimal(msOrder.getContractPrice()));
//                orderAuditReq.setBalanceQuantity(new BigDecimal(msOrder.getContractAmount()));
//                orderAuditReq.setTotalDeliveryFee(new BigDecimal(msOrder.getTranportFee()));
//                orderAuditReq.setContractNo(msOrder.getContractNo());
//                orderAuditReq.setPayClause(msOrder.getPayClause());
//                orderAuditReq.setContractTotal(new BigDecimal(msOrder.getContractTotal()));
//                orderAuditReq.setContractTime(DateUtil.parse(msOrder.getContractTime(), "yyyy-MM-dd HH:mm:ss"));
//                orderFeignClient.saveOrderAuditRst(orderAuditReq);
//            } catch (Exception e) {
//                logger.error("[订单] 更新订单审核结果失败，报文={}",gson.toJson(record), e);
//                throw e;
//            }
//        }
//    }

}
