package workquene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        //通过工具类获取连接
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work", true, false, false, null);
        for (int i = 0; i < 20; i++) {
            channel.basicPublish("","work",null,(i + "hello work quene").getBytes());
        }
        //调用工具类关闭
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
