package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsETE;
//import com.sinochem.gateway.wms.api.to.service.MsMerchantCredential;
import com.sinochem.member.api.feign.EnterpriseQualificationFeignClient;
import com.sinochem.member.api.to.EnterpriseQualificationTopicTO;
import com.sinochem.member.api.vo.EnterpriseQualificationVO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sagacity.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author changzhiduo
 * @description 企业资质消息同步
 * @date 2018/8/22
 */
@Component
public class EnterpriseQualificationListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(EnterpriseQualificationListener.class);
//
//    /**
//     * 企业资质远程接口
//     */
//    @Resource
//    private EnterpriseQualificationFeignClient enterpriseQualificationFeignClient;
//
//    /**
//     * 企业资质注册通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.ENTERPRISE_QUALIFICATION_SYNC_TOPIC)
//    public void receiveUserReg(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[企业资质] 企业资质信息：{}" + gson.toJson(record));
//        enterpriseQualificationSyncTopic(record, gson);
//    }
//
//    /**
//     * 企业资质注册或更新
//     * @param record
//     * @param gson
//     */
//    private void enterpriseQualificationSyncTopic(ConsumerRecord<?, ?> record, Gson gson) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //企业资质数据转换
//                MsMerchantCredential msMerchantCredential = gson.fromJson(message.toString(), MsMerchantCredential.class);
//                //企业资质注册参数验证
//                boolean valid = validEnterpriseQualification(msMerchantCredential);
//                if(valid){
//                    //转换为企业资质对象
//                    EnterpriseQualificationTopicTO enterpriseQualificationTopicTO = assembleEnterpriseQualificationVO(msMerchantCredential);
//                    //更新
//                    enterpriseQualificationFeignClient.saveOrupdateForTopic(enterpriseQualificationTopicTO);
//                }
//            } catch (Exception e) {
//                logger.error("[企业资质] 企业资质同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为企业资质对象
//     * @param msMerchantCredential
//     * @return
//     */
//    private EnterpriseQualificationTopicTO assembleEnterpriseQualificationVO(MsMerchantCredential msMerchantCredential) {
//        EnterpriseQualificationTopicTO EnterpriseQualificationTopicTO = new EnterpriseQualificationTopicTO();
//        BeanUtils.copyProperties(msMerchantCredential,EnterpriseQualificationTopicTO);
//        return EnterpriseQualificationTopicTO;
//    }
//
//    /**
//     * 企业资质注册参数验证
//     * @param msMerchantCredential
//     * @return
//     */
//    private boolean validEnterpriseQualification(MsMerchantCredential msMerchantCredential) {
//        if(msMerchantCredential!=null){
//            // 判断企业标识是否为空
//            if (StringUtil.isNullOrBlank(msMerchantCredential.getEnterpriseId())) {
//                logger.error("企业标识为空:"+msMerchantCredential);
//                return false;
//            }
//
//            return true;
//        }
//       return false;
//    }
}
