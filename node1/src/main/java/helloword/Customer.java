package helloword;

import com.rabbitmq.client.*;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeoutException;

public class Customer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //通过工具类获取连接
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", false, false, false, null);
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override//最后一个参数：消息队列中去除的消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
        //调用工具类关闭
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
