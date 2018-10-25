package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.sinochem.component.common.entity.BizResult;
import com.sinochem.component.common.enums.ApplyStatusEnum;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsETE;
//import com.sinochem.gateway.wms.api.to.service.MsUserMerchant;
import com.sinochem.member.api.feign.EnterpriseMemberFeignClient;
import com.sinochem.member.api.feign.EnterpriseMiddleFeignClient;
import com.sinochem.member.api.vo.EnterpriseMemberVO;
import com.sinochem.member.api.vo.EnterpriseMiddleVO;
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
 * @description 买家、卖家企业关联消息同步
 * @date 2018/8/22
 */
@Component
public class EnterpriseMiddleListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(EnterpriseMiddleListener.class);
//
//    /**
//     * 买家、卖家企业关联远程接口
//     */
//    @Resource
//    private EnterpriseMiddleFeignClient enterpriseMiddleFeignClient;
//
//    /**
//     * 买家、卖家企业关联注册通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.ENTERPRISE_ENTERPRISE_SYNC_TOPIC)
//    public void receiveUserReg(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[买家、卖家企业关联] 买家、卖家企业关联信息：{}" + gson.toJson(record));
//        enterpriseMiddleSyncTopic(record, gson);
//    }
//
//    /**
//     * 买家、卖家企业关联注册或更新
//     * @param record
//     * @param gson
//     */
//    private void enterpriseMiddleSyncTopic(ConsumerRecord<?, ?> record, Gson gson) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //买家、卖家企业关联数据转换
//                MsETE msETE = gson.fromJson(message.toString(), MsETE.class);
//                //买家、卖家企业关联注册参数验证
//                boolean valid = validEnterpriseMiddle(msETE);
//                if(valid){
//                    //转换为买家、卖家企业关联对象
//                    EnterpriseMiddleVO enterpriseMiddleVO = assembleEnterpriseMiddleVO(msETE);
//                    //更新
//                    enterpriseMiddleFeignClient.saveOrupdate(enterpriseMiddleVO);
//                }
//            } catch (Exception e) {
//                logger.error("[买家、卖家企业关联] 买家、卖家企业关联同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为买家、卖家企业关联对象
//     * @param msETE
//     * @return
//     */
//    private EnterpriseMiddleVO assembleEnterpriseMiddleVO(MsETE msETE) {
//        if(StringUtil.isNullOrBlank(msETE.getEnabled())){
//            msETE.setEnabled("1");
//        }
//        EnterpriseMiddleVO enterpriseMiddleVO = new EnterpriseMiddleVO();
//        BeanUtils.copyProperties(msETE,enterpriseMiddleVO);
//        enterpriseMiddleVO.setEnabled(Integer.parseInt(msETE.getEnabled()));
//        return enterpriseMiddleVO;
//    }
//
//    /**
//     * 买家、卖家企业关联注册参数验证
//     * @param msETE
//     * @return
//     */
//    private boolean validEnterpriseMiddle(MsETE msETE) {
//        if(msETE!=null){
//            // 判断企业间关联标识是否为空
//            if (StringUtil.isNullOrBlank(msETE.getEnterpriseMidId())) {
//                logger.error("企业间关联标识为空:"+msETE);
//                return false;
//            }
//
//            // 检查企业标识（卖家）是否为空
//            if (StringUtil.isNullOrBlank(msETE.getSellerEnterpriseId())) {
//                logger.error("企业标识（卖家）为空:"+msETE);
//                return false;
//            }
//            // 检查企业标识（买家）是否为空
//            if (StringUtil.isNullOrBlank(msETE.getBuyerEnterpriseId())){
//                logger.error("企业标识（买家）为空:"+msETE);
//                return false;
//            }
//            // 检查委托人标识（买家）是否为空
//            if (StringUtil.isNullOrBlank(msETE.getBuyerMemberId())) {
//                logger.error("委托人标识（买家）为空:"+msETE);
//                return false;
//            }
//            // 检查是否启用为空
//            if (StringUtil.isNullOrBlank(msETE.getEnabled())) {
//                logger.error("是否启用为空:"+msETE);
//                return false;
//            }
//            return true;
//        }
//       return false;
//    }
}
