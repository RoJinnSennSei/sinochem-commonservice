package com.sinochem.mq.kafka.service;



/**
 * @author xuan  <a href="zhangshixuanj@163.com">联系作者</a>
 * @version Revision:v1.0,Date: 2018/1/13 11:51
 * @project sinochem-parent
 * @description 消息队列
 * @Modification Date: 2018/1/13 11:51  {填写修改说明}
 */
public interface IKafkaService {

    /**
     * 发送
     *
     * @param topic
     * @param data
     */
    boolean send(String topic, Object data);
}
