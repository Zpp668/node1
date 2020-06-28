package helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        //通过工具类获取连接
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接中通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列
        //参数1：队列名称 若果队列中不存在自动创建
        //参数2：用来定义队列特性是否要持久化 true持久化队列 false不持久化
        //参数3：exclusive 是否独占队列 true代表独占 false不独占
        //参数4：autoDelete 是否在消费完成之后自动删除队列 true自动删除 false不自动删除
        //参数5：额外附加参数
        channel.queueDeclare("hello",false,false,false,null);
        //发布消息
        //参数1：交换机名称，参数2：队列名称，参数3：传递消息额外设置(传的参数是消息持久化)，参数4：消息的具体内容
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitmq".getBytes());
        //调用工具类关闭
        RabbitMQUtils.closeConnectionAndChanel(channel,connection);
    }
}
