package com.sinochem.mq.kafka;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sinochem.common.api.feign.BizLogFeignClient;
import com.sinochem.common.api.feign.SMSFeignClient;
import com.sinochem.common.api.vo.SendEmailinfoVO;
import com.sinochem.common.api.vo.SendSmsinfoVO;
import com.sinochem.component.common.constant.MqTopicConstant;
import com.sinochem.net.api.feign.WebnetFeignClient;
import com.sinochem.net.api.vo.MessageVo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 
* 项目名称：sinochem-commonservice-mq  
* @ClassName: ConsumerListener 
* @Description: TODO(消息监听器) 
* @author yekairush@163.com
* @date 2018年1月16日 下午4:07:29
 */
@Component
public class ConsumerListener {
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ConsumerListener.class);
    
    @Autowired
	private RestTemplate restTemplate;

    @Autowired
    private BizLogFeignClient logFeignClient;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	@Resource
	private WebnetFeignClient webnetFeignClient;

	@Resource
	private SMSFeignClient smsFeignClient;

    /**
     * 短信发送
     * @param record
     */
    @KafkaListener(topics = MqTopicConstant.SMS_TOPICS)
    public void monitorSms(ConsumerRecord<?, ?> record) {
		Gson gson = new Gson();
		logger.error("短信topic" + gson.toJson(record));
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object SendSmsinfo = kafkaMessage.get();
			SendSmsinfoVO sendSmsinfoVO =gson.fromJson(SendSmsinfo.toString(), SendSmsinfoVO.class);
			smsFeignClient.sendSmsinfo(sendSmsinfoVO);
		}
    }

    /**
     * 邮件发送
     * @param record
     */
    @KafkaListener(topics = MqTopicConstant.EMAIL_TOPICS)
    public void monitorEmail(ConsumerRecord<?, ?> record) {
    	 Gson gson = new Gson();
    	 logger.error("监听器" + gson.toJson(record));
         Optional<?> kafkaMessage = Optional.ofNullable(record.value());
	    try {
		    if (kafkaMessage.isPresent()) {
		        Object sendEmailinfo = kafkaMessage.get();
		        SendEmailinfoVO sendEmailinfoVO =gson.fromJson(sendEmailinfo.toString(), SendEmailinfoVO.class);
		        smsFeignClient.sendEmailinfo(sendEmailinfoVO);
			    logger.error("监听器" + sendEmailinfoVO);
		    }
	    } catch (JsonSyntaxException e) {
		    logger.error("监听器结果处理失败" + e.getMessage(),e);
	    }
    }
    
	   /**
	   * 消息发送
	   * @param record
	   */
	  @KafkaListener(topics = MqTopicConstant.MSG_TOPICS)
	  public void monitorMsg(ConsumerRecord<?, ?> record) {
	  	   Gson gson = new Gson();
	  	   logger.error("监听器" + gson.toJson(record));
	       Optional<?> kafkaMessage = Optional.ofNullable(record.value());
	       if (kafkaMessage.isPresent()) {
	           Object message = kafkaMessage.get();
	           try {
	        	   
		           MessageVo messageVo =gson.fromJson(message.toString(), MessageVo.class);
		           webnetFeignClient.pushMsg(messageVo);
	           } catch (Exception e) {
	        	   logger.error("监听器结果处理失败" + e.getMessage(),e);
	           }
	       }
	  }

	/**
	 * 竞拍消息发送
	 * 
	 * @param record
	 */
	@KafkaListener(topics = MqTopicConstant.MSG_AUCTION_TOPICS)
	public void auctionMsg(ConsumerRecord<?, ?> record) {
		Gson gson = new Gson();
		logger.error("监听器" + gson.toJson(record));
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			try {
				webnetFeignClient.pushAuctionMsg(message.toString());
			} catch (Exception e) {
				logger.error("监听器结果处理失败" + e.getMessage(), e);
			}
		}
	}

}