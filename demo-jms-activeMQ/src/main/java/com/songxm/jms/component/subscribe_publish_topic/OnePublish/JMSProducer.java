package com.songxm.jms.component.subscribe_publish_topic.OnePublish;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author: sxm
 * @date: 16/11/30 18:56
 * @version: v1.0.0
 */
@Component
public class JMSProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session;//发送或者接受消息的线程
        Destination destination; //消息的目的地
        MessageProducer messageProducer;//消息生产者

        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWD, BROKEURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//创建session,TRUE标志位事务
            destination = session.createTopic("First-Queue"); //创建topic发布者
            messageProducer = session.createProducer(destination); //创建消息生产者

            sendMessage(session, messageProducer); //发送消息
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }

    }


    /**
     * 发送消息
     *
     * @param session
     * @param messageProducer
     */
    public static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage message = session.createTextMessage(" activeMQ 发布topic的消息" + i);
            System.out.println("发布topic消息: " + message);
            messageProducer.send(message);
        }
    }
}
