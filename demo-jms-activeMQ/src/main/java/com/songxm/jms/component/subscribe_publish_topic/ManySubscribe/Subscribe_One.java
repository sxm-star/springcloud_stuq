package com.songxm.jms.component.subscribe_publish_topic.ManySubscribe;

import com.songxm.jms.component.subscribe_publish_topic.listener.JMSListener_One;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author: sxm
 * @date: 17/5/30 20:51
 * @version: v1.0.0
 */
public class Subscribe_One {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接
        Session session;//发送或者接受消息的线程
        Destination destination; //消息的目的地
        MessageConsumer messageConsumer; //消息消费者
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWD, BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);//创建session,TRUE标志位事务
            destination = session.createTopic("First-Queue"); //订阅者一 订阅topic
            messageConsumer = session.createConsumer(destination); //创建消息生产者

            messageConsumer.setMessageListener(new JMSListener_One()); //注册监听

            while (true){

            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
