package com.songxm.jms.component.subscribe_publish_topic.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author: sxm
 * @date: 16/11/30 20:17
 * @version: v1.0.0
 */
public class JMSListener_Three implements MessageListener{

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("以监听模式 订阅者三 订阅消息:" + ((TextMessage)message).getText());
        }catch (JMSException e){
            e.printStackTrace();
        }

    }
}
