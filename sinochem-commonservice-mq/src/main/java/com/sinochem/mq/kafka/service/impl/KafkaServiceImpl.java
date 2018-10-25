package com.sinochem.mq.kafka.service.impl;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

import com.sinochem.mq.kafka.service.IKafkaService;

/**
 * @author xuan  <a href="zhangshixuanj@163.com">联系作者</a>
 * @version Revision:v1.0,Date: 2018/1/13 12:04
 * @project sinochem-parent
 * @description
 * @Modification Date: 2018/1/13 12:04  {填写修改说明}
 */
@Service
public class KafkaServiceImpl implements IKafkaService {
    private final static Logger logger = Logger.getLogger(KafkaServiceImpl.class);

    @SuppressWarnings("rawtypes")
	@Autowired
    private KafkaTemplate kafkaTemplate;

    @SuppressWarnings("unchecked")
	@Override
    public boolean send(String topic, Object data) {
        logger.info("向kafka推送数据:[{}] data="+data);
        try {
        	
            kafkaTemplate.send(topic, data);
        } catch (Exception e) {
        	logger.error("发送数据出错！！！{}{}"+" topic="+ topic+"  data="+ data);
            logger.error("发送数据出错=====>e="+e);
            return false;
        }

        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
        	/**
        	 * 发送消息成功后调用 
        	 */
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
            	
            	logger.info("onSuccess="+topic+" partition="+partition +" key="+key +" value="+value +" recordMetadata="+recordMetadata);
            }

            /**
             *  发送消息错误后调用 
             */
            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
            	 logger.info("onError="+topic+" partition="+partition +" key="+key +" value="+value);
            }

            /**
             * 方法返回值代表是否启动kafkaProducer监听器 
             */
            @Override
            public boolean isInterestedInSuccess() {
            	 logger.info("isInterestedInSuccess="+topic);
                return true;
            }
        });
        return true;
    }
}
