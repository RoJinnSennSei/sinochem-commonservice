package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.sinochem.component.common.entity.BizResult;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsMerchantAddress;
import com.sinochem.member.api.feign.EnterpriseDeliveryAddressFeignClient;
import com.sinochem.member.api.vo.EnterpriseDeliveryAddressVO;
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
 * @description 商户收货地址消息同步
 * @date 2018/8/22
 */
@Component
public class EnterpriseAddrListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(EnterpriseAddrListener.class);
//
//    /**
//     * 商户收货地址远程接口
//     */
//    @Resource
//    private EnterpriseDeliveryAddressFeignClient enterpriseDeliveryAddressFeignClient;
//
//    /**
//     * 商户收货地址信息同步通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.ENTERPRISE_ADDR_SYNC_TOPIC)
//    public void receiveUserSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[商户收货地址] 商户收货地址同步信息：{}" + gson.toJson(record));
//        //商户收货地址注册或更新
//        enterpriseDeliveryAddressSyncTopic(record, gson);
//    }
//
//    /**
//     * 商户收货地址注册或更新
//     * @param record
//     * @param gson
//     */
//    private void enterpriseDeliveryAddressSyncTopic(ConsumerRecord<?, ?> record, Gson gson) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //商户收货地址数据转换
//                MsMerchantAddress msMerchantAddress = gson.fromJson(message.toString(), MsMerchantAddress.class);
//                //商户收货地址注册参数验证
//                boolean valid = validDeliveryAddressReg(msMerchantAddress);
//                if(valid){
//                    //转换为商户收货地址对象
//                    EnterpriseDeliveryAddressVO enterpriseDeliveryAddressVO = assembleEnterpriseDeliveryAddressVo(msMerchantAddress);
//                    BizResult<EnterpriseDeliveryAddressVO> bizResult = enterpriseDeliveryAddressFeignClient.findEntDeliveryAddressByAddressId(enterpriseDeliveryAddressVO.getDeliveryAddressId());
//                    if(bizResult!=null && bizResult.getData()!=null){
//                        //更新
//                        enterpriseDeliveryAddressFeignClient.updateEnterpriseDeliveryAddress(enterpriseDeliveryAddressVO);
//                    }else{
//                        //保存
//                        enterpriseDeliveryAddressFeignClient.addEnterpriseDeliveryAddress(enterpriseDeliveryAddressVO);
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("[商户收货地址] 商户收货地址同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为商户收货地址对象
//     * @param msMerchantAddress
//     * @return
//     */
//    private EnterpriseDeliveryAddressVO assembleEnterpriseDeliveryAddressVo(MsMerchantAddress msMerchantAddress) {
//        EnterpriseDeliveryAddressVO enterpriseDeliveryAddressVO = new EnterpriseDeliveryAddressVO();
//        BeanUtils.copyProperties(msMerchantAddress,enterpriseDeliveryAddressVO);
//        return enterpriseDeliveryAddressVO;
//    }
//
//    /**
//     * 商户收货地址注册参数验证
//     * @param msMerchantAddress
//     * @return
//     */
//    private boolean validDeliveryAddressReg(MsMerchantAddress msMerchantAddress) {
//        if(msMerchantAddress!=null){
//            // 判断企业标识为空
//            if (StringUtil.isNullOrBlank(msMerchantAddress.getEnterpriseId())) {
//                logger.error("企业标识enterpriseId为空:"+msMerchantAddress.getEnterpriseId());
//                return false;
//            }
//            // 判断主键标识为空
//            if (StringUtil.isNullOrBlank(msMerchantAddress.getDeliveryAddressId())) {
//                logger.error("deliveryAddressId为空:"+msMerchantAddress.getEnterpriseId());
//                return false;
//            }
//            return true;
//        }
//       return false;
//    }
}
