package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.sinochem.component.common.entity.BizResult;
import com.sinochem.component.common.enums.ApplyStatusEnum;
import com.sinochem.component.common.utils.DataVerifyUtil;
import com.sinochem.component.common.utils.DateUtil;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsUser;
//import com.sinochem.gateway.wms.api.to.service.MsUserMerchant;
import com.sinochem.member.api.feign.EnterpriseMemberFeignClient;
import com.sinochem.member.api.feign.MemberFeignClient;
import com.sinochem.member.api.to.EnterpriseMemberTO;
import com.sinochem.member.api.vo.EnterpriseMemberVO;
import com.sinochem.member.api.vo.MemberAccountVO;
import com.sinochem.member.api.vo.MemberVO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.sagacity.core.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @author changzhiduo
 * @description 用户企业关联消息同步
 * @date 2018/8/22
 */
@Component
public class UserEnterpriseListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(UserEnterpriseListener.class);
//
//    /**
//     * 用户企业远程接口
//     */
//    @Resource
//    private EnterpriseMemberFeignClient enterpriseMemberFeignClient;
//
//    /**
//     * 用户企业关联注册通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.USER_ENTERPRISE_SYNC_TOPIC)
//    public void receiveUserReg(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[用户企业关联] 用户企业关联信息：{}" + gson.toJson(record));
//        enterpriseMemberRegSyncTopic(record, gson);
//    }
//
//    /**
//     * 用户企业关联注册或更新
//     * @param record
//     * @param gson
//     */
//    private void enterpriseMemberRegSyncTopic(ConsumerRecord<?, ?> record, Gson gson) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //用户企业关联数据转换
//                MsUserMerchant msUserMerchant = gson.fromJson(message.toString(), MsUserMerchant.class);
//                //用户企业关联注册参数验证
//                boolean valid = validUserEnterprise(msUserMerchant);
//                if(valid){
//                    //转换为用户企业对象
//                    EnterpriseMemberVO enterpriseMemberVO = assembleEnterpriseMemberVO(msUserMerchant);
//
//                    BizResult<EnterpriseMemberVO> bizResult = enterpriseMemberFeignClient.findByEnterpriseMemberId(enterpriseMemberVO.getEnterpriseMemberId());
//                    if(bizResult!=null && bizResult.getData()!=null){
//                        //更新
//                        enterpriseMemberFeignClient.update(enterpriseMemberVO);
//                    }else{
//                        //保存
//                        enterpriseMemberFeignClient.apply(enterpriseMemberVO);
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("[用户企业关联] 用户企业关联同步失败", e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为用户企业对象
//     * @param msUserMerchant
//     * @return
//     */
//    private EnterpriseMemberVO assembleEnterpriseMemberVO(MsUserMerchant msUserMerchant) {
//        if(StringUtil.isNullOrBlank(msUserMerchant.getEnabled())){
//            msUserMerchant.setEnabled("1");
//        }
//        EnterpriseMemberVO enterpriseMemberVO = new EnterpriseMemberVO();
//        BeanUtils.copyProperties(msUserMerchant,enterpriseMemberVO);
//        enterpriseMemberVO.setStatus(ApplyStatusEnum.PASS.getCode());
//        enterpriseMemberVO.setEnterpriseMemberId(msUserMerchant.getMemEntId());
//        enterpriseMemberVO.setIsLocked(Integer.parseInt(msUserMerchant.getEnabled()));
//        enterpriseMemberVO.setUserStatus(msUserMerchant.getEnabled());
//        return enterpriseMemberVO;
//    }
//
//    /**
//     * 用户企业关联注册参数验证
//     * @param msUserMerchant
//     * @return
//     */
//    private boolean validUserEnterprise(MsUserMerchant msUserMerchant) {
//
//        if(msUserMerchant!=null){
//            // 判断企业用户标识是否为空
//            if (StringUtil.isNullOrBlank(msUserMerchant.getMemEntId())) {
//                logger.error("企业用户标识为空:"+msUserMerchant);
//                return false;
//            }
//
//            // 检查用户标识是否为空
//            if (StringUtil.isNullOrBlank(msUserMerchant.getMemberId())) {
//                logger.error("用户标识为空:"+msUserMerchant);
//                return false;
//            }
//            // 检查企业标识是否为空
//            if (StringUtil.isNullOrBlank(msUserMerchant.getEnterpriseId())){
//                logger.error("企业标识为空:"+msUserMerchant);
//                return false;
//            }
//            return true;
//        }
//       return false;
//    }
}
