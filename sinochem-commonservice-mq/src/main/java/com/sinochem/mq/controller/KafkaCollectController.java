package com.sinochem.mq.controller;


import com.google.gson.Gson;
import com.sinochem.common.api.vo.SendEmailinfoVO;
import com.sinochem.common.api.vo.SendSmsinfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sinochem.component.common.constant.MqTopicConstant;
import com.sinochem.component.common.entity.MqMessage;
import com.sinochem.mq.kafka.service.IKafkaService;

/**
 * 项目名称：sinochem-commonservice-mq
 *
 * @author yekairush@163.com
 * @ClassName: KafkaCollectController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年1月16日 下午1:57:04
 */
@RestController
@RequestMapping("/mq")
public class KafkaCollectController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IKafkaService kafkaService;

    /**
     * 推送消息
     *
     * @param message
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void send(@RequestBody MqMessage message) {
        try {
            logger.info("mq的消息={}");
            String topic = message.getTopicName();
            logger.info("mq的消息={}" + topic);
            String str = message.getObj();
            kafkaService.send(topic, str);
        } catch (Exception e) {
            logger.error("发送mq的消息失败", e);
        }
    }

    /**
     * 发送邮件消息
     *
     * @param sendEmailinfoVO
     * @throws Exception
     */
    @PostMapping("/sendEmailinfo")
    public void sendEmailinfo(@RequestBody SendEmailinfoVO sendEmailinfoVO) {
        try {
            Gson gson = new Gson();
            logger.info("kafka的消息={}" + sendEmailinfoVO);
            kafkaService.send(MqTopicConstant.EMAIL_TOPICS, gson.toJson(sendEmailinfoVO));
        } catch (Exception e) {
            logger.error("发送邮件失败", e);
        }
    }


    /**
     * 发送短信消息
     *
     * @param sendSmsinfoVO
     */
    @PostMapping("sendSmsinfo")
    public void sendSmsinfo(@RequestBody SendSmsinfoVO sendSmsinfoVO) {
        try {
            Gson gson = new Gson();
            logger.info("kafka的消息={}" + sendSmsinfoVO);
            kafkaService.send(MqTopicConstant.SMS_TOPICS, gson.toJson(sendSmsinfoVO));
        } catch (Exception e) {
            logger.error("发送短信", e);
        }
    }
    
    
    /**
     * 推送消息
     *
     * @param message
     */
    @RequestMapping(value = "/send1", method = RequestMethod.GET)
    public void send1() {
        try {
//            logger.info("mq的消息={}");
//            String topic = message.getTopicName();
//            logger.info("mq的消息={}" + topic);
//            String str = message.getObj();
        	String topic="EMAIL_TOPICS";
            kafkaService.send(topic, "ccc");
        } catch (Exception e) {
            logger.error("发送mq的消息失败", e);
        }
    }
}