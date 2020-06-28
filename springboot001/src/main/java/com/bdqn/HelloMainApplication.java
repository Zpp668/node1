package com.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication来标注一个主程序类，说明这是一个springboot应用
 */

@SpringBootApplication
public class HelloMainApplication {
    public static void main(String[] args) {
        //spring项目启动起来
        SpringApplication.run(HelloMainApplication.class,args);
    }
}
