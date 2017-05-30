package com.songxm.jms.component.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @author: sxm
 * @date: 16/11/30 19:51
 * @version: v1.0.0
 */
@Component
public class JMSConsumer {
    private static final String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL= ActiveMQConnection.DEFAULT_BROKER_URL;
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
            destination = session.createQueue("First-Queue"); //创建消息队列
            messageConsumer = session.createConsumer(destination); //创建消息生产者

            while (true){
              TextMessage message =   (TextMessage)messageConsumer.receive(100_000);
                if (null!=message){
                    System.out.println("收到的消息:" + message.getText());
                }
            }
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
}
