package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.sinochem.component.common.utils.DataVerifyUtil;
import com.sinochem.component.common.utils.DateUtil;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsMerchant;
//import com.sinochem.gateway.wms.api.to.service.MsUser;
import com.sinochem.member.api.feign.EnterpriseFeignClient;
import com.sinochem.member.api.feign.MemberFeignClient;
import com.sinochem.member.api.vo.EnterpriseVO;
import com.sinochem.member.api.vo.MemberAccountVO;
import com.sinochem.member.api.vo.MemberVO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sagacity.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @author changzhiduo
 * @description 商户消息同步
 * @date 2018/8/22
 */
@Component
public class EnterpriseListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(EnterpriseListener.class);
//
//    /**
//     * 商户远程接口
//     */
//    @Resource
//    private EnterpriseFeignClient enterpriseFeignClient;
//
//    /**
//     * 商户注册通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.ENTERPRISE_REG_TOPIC)
//    public void receiveUserReg(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商户] 商户注册信息：{}" + gson.toJson(record));
//        enterpriseRegSyncTopic(record, gson,"reg");
//    }
//
//    /**
//     * 商户信息同步通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.ENTERPRISE_SYNC_TOPIC)
//    public void receiveUserSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商户] 商户同步信息：{}" + gson.toJson(record));
//        //商户注册或更新
//        enterpriseRegSyncTopic(record, gson,"sync");
//    }
//
//    /**
//     * 商户注册或更新
//     * @param record
//     * @param gson
//     */
//    private void enterpriseRegSyncTopic(ConsumerRecord<?, ?> record, Gson gson,String type) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //商户数据转换
//                MsMerchant msMerchant = gson.fromJson(message.toString(), MsMerchant.class);
//                //商户注册参数验证
//                boolean valid = validEnterpriseReg(msMerchant);
//                if(valid){
//                    //转换为商户对象
//                    EnterpriseVO enterpriseVO = assembleEnterpriseVo(msMerchant);
//                    if("reg".equals(type)){
//                        //商户注册
//                        enterpriseFeignClient.insertEnterpriseByName(enterpriseVO);
//                    }else if("sync".equals(type)){
//                        //更新商户
//                        enterpriseFeignClient.updateEnterprise(enterpriseVO);
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("[商户] 商户注册、同步失败"+type, e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为商户对象
//     * @param msMerchant
//     * @return
//     */
//    private EnterpriseVO assembleEnterpriseVo(MsMerchant msMerchant) {
//        EnterpriseVO enterpriseVO = new EnterpriseVO();
//        BeanUtils.copyProperties(msMerchant,enterpriseVO);
//        return enterpriseVO;
//    }
//
//    /**
//     * 商户注册参数验证
//     * @param msMerchant
//     * @return
//     */
//    private boolean validEnterpriseReg(MsMerchant msMerchant) {
//        if(msMerchant!=null){
//            // 判断手机号是否为空
//            if (StringUtil.isNullOrBlank(msMerchant.getEnterpriseId())) {
//                logger.error("企业标识enterpriseId为空:"+msMerchant.getEnterpriseId());
//                return false;
//            }
//            return true;
//        }
//       return false;
//    }
}
