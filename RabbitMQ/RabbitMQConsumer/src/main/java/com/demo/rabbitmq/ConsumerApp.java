package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ConsumerApp {

    // Queue name (must match producer queue)
    private static final String QUEUE_NAME = "student_queue";

    public static void main(String[] args) {

        try {

            // 1. Create connection factory
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.1.36");
            factory.setPort(5672);
            factory.setUsername("appuser");
            factory.setPassword("123456");

            // 2. Create connection
            Connection connection = factory.newConnection();

            // 3. Create channel
            Channel channel = connection.createChannel();

            // 4. Declare queue (safe if already exists)
            channel.queueDeclare(
                    QUEUE_NAME,
                    false,
                    false,
                    false,
                    null
            );

            System.out.println(" Waiting for messages... ");

            // 5. Create consumer
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {

                String message = new String(
                        delivery.getBody(),
                        "UTF-8"
                );

                System.out.println(" Received: " + message);
            };

            // 6. Start consuming
            channel.basicConsume(
                    QUEUE_NAME,
                    true,
                    deliverCallback,
                    consumerTag -> {}
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
