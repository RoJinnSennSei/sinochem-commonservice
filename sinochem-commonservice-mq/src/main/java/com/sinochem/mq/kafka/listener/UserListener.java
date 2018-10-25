package com.sinochem.mq.kafka.listener;

import com.google.gson.Gson;
import com.sinochem.component.common.entity.BizResult;
import com.sinochem.component.common.utils.DataVerifyUtil;
import com.sinochem.component.common.utils.DateUtil;
//import com.sinochem.gateway.wms.api.constant.WmsConstant;
//import com.sinochem.gateway.wms.api.to.service.MsGood;
//import com.sinochem.gateway.wms.api.to.service.MsUser;
import com.sinochem.goods.api.feign.GoodsFeignClient;
import com.sinochem.goods.api.feign.ResourceBuyerPriceFeignClient;
import com.sinochem.goods.api.feign.ResourceFeignClient;
import com.sinochem.goods.api.vo.*;
import com.sinochem.member.api.feign.MemberFeignClient;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author changzhiduo
 * @description 用户消息同步
 * @date 2018/8/22
 */
@Component
public class UserListener {
//
//    private final static Logger logger = LoggerFactory.getLogger(UserListener.class);
//
//    /**
//     * 会员远程接口
//     */
//    @Resource
//    private MemberFeignClient memberFeignClient;
//
//    /**
//     * 用户注册通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.USER_REG_TOPIC)
//    public void receiveUserReg(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[用户] 用户注册信息：{}" + gson.toJson(record));
//        userRegSyncTopic(record, gson,"reg");
//    }
//
//    /**
//     * 用户信息同步通知MQ通道
//     * @param record
//     */
//    @KafkaListener(topics = WmsConstant.USER_SYNC_TOPIC)
//    public void receiveUserSync(ConsumerRecord<?, ?> record) {
//        Gson gson = new Gson();
//        logger.info("[用户] 用户同步信息：{}" + gson.toJson(record));
//        //用户注册或更新
//        userRegSyncTopic(record, gson,"sync");
//    }
//
//    /**
//     * 用户注册或更新
//     * @param record
//     * @param gson
//     */
//    private void userRegSyncTopic(ConsumerRecord<?, ?> record, Gson gson,String type) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            try {
//                //用户数据转换
//                MsUser msUser = gson.fromJson(message.toString(), MsUser.class);
//                //用户注册参数验证
//                boolean valid = validUserReg(msUser);
//                if(valid){
//                    //转换为会员对象
//                    MemberVO memberVO = assembleMemberVo(msUser);
//                    //转换为会员账号对象
//                    MemberAccountVO memberAccountVO = assembleMemberAccountVo(msUser);
//                    if("reg".equals(type)){
//                        //设置默认密码，此密码不能作为登录使用
//                        memberAccountVO.setPassword("e99a18c428cb38d5f260853678922e03");
//                        //注册
//                        memberFeignClient.register(memberAccountVO);
//                    }else if("sync".equals(type)){
//                        //更新会员账号
//                        memberFeignClient.updateAccount(memberAccountVO);
//                    }
//                    //更新会员
//                    memberFeignClient.updateAndSync(memberVO);
//                }
//            } catch (Exception e) {
//                logger.error("[用户] 用户注册、同步失败"+type, e);
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * 转换为会员对象
//     * @param msUser
//     * @return
//     */
//    private MemberVO assembleMemberVo(MsUser msUser) {
//        MemberVO memberVO = new MemberVO();
//        BeanUtils.copyProperties(msUser,memberVO);
//        memberVO.setMemberType(1);
//        memberVO.setEnabled(1);
//        //设置birthday
//        String dateStr = msUser.getBirthDay();
//        if(StringUtil.isNotNullAndBlank(dateStr)){
//            Date date = DateUtil.str2Date(dateStr,"yyyy-MM-dd");
//            memberVO.setBirthDay(date);
//        }
//        return memberVO;
//    }
//
//    /**
//     * 转换为会员账号对象
//     * @param msUser
//     * @return
//     */
//    private MemberAccountVO assembleMemberAccountVo(MsUser msUser) {
//        MemberAccountVO memberAccountVO = new MemberAccountVO();
//        BeanUtils.copyProperties(msUser,memberAccountVO);
//        return memberAccountVO;
//    }
//
//    /**
//     * 用户注册参数验证
//     * @param msUser
//     * @return
//     */
//    private boolean validUserReg(MsUser msUser) {
//        if(msUser!=null){
//            // 判断手机号是否为空
//            if (StringUtil.isNullOrBlank(msUser.getMobile())) {
//                logger.error("手机号为空:"+msUser);
//                return false;
//            }
//
//            // 检查手机号码格式
//            if (!DataVerifyUtil.checkMobile(msUser.getMobile())) {
//                logger.error("手机号码格式不正确:"+msUser);
//                return false;
//            }
//            return true;
//        }
//       return false;
//    }
}
