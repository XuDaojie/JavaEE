package io.github.xudaojie.javase.rabbitmq.routing;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * Created by xdj on 2017/5/21.
 */
public class ReceiveLogsDirect1 {

    private final static String EXCHANGE_NAME = "direct_logs";
    private static final String[] routingKeys = new String[]{"info", "warning", "error"};

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();
        for (String severity : routingKeys) {
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
            System.out.println("ReceiveLogsDirect1 exchange: " + EXCHANGE_NAME
                    + ", queue: " + queueName + ", BindRoutingKey: " + severity);
        }
        System.out.println("ReceiveLogsDirect1 [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + message + "'");
            }
        };
        // 消息消费完成确认
        channel.basicConsume(queueName, true, consumer);
    }

}
