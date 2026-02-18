package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerApp {

    private static final String QUEUE_NAME = "student_queue";

    public static void main(String[] args) {

        try {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.1.36");    //RabbitMQ Server IP Address
             factory.setPort(5672);
            factory.setUsername("appuser");     //RabbitMQ Server Username
            factory.setPassword("123456");      //RabbitMQ Server Password

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(
                    QUEUE_NAME,
                    false,
                    false,
                    false,
                    null
            );

            String message = "Hello Student from Nikita";

            channel.basicPublish(
                    "",
                    QUEUE_NAME,
                    null,
                    message.getBytes()
            );

            System.out.println(" Sent: " + message);

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
