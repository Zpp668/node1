package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {
    //创建连接mq的连接工厂对象
    private static ConnectionFactory connectionFactory;
    //初始化，只运行一次
    static {
        connectionFactory = new ConnectionFactory();
        //设置连接rabbitmq主机
        connectionFactory.setHost("localhost");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置访问虚拟主机的 用户名和密码
        connectionFactory.setUsername("zpp");
        connectionFactory.setPassword("123");
    }
    //定义提供的方法
    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //关闭通道和关闭连接工具方法
    public static void closeConnectionAndChanel(Channel channel, Connection conn){
        try{
            if(channel != null) channel.close();
            if(conn != null) conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
