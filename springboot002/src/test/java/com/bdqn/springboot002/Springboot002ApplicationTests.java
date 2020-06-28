package com.bdqn.springboot002;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bdqn.springboot002.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot002ApplicationTests {
    @Autowired
    Person person;
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
//        System.out.println(person);
       logger.trace("这是trace日志");
       logger.debug("这是debug日志");
       logger.info("info");
       logger.warn("warn");
       logger.error("这是error");
    }
}
