package com.zkml.controller;

import com.zkml.service.PublisherService;
import com.zkml.test.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main2 {

    @Test
    public void test1(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService testService= (TestService) context.getBean("testService");
//        TestController testController =(TestController)context.getBean("testController");
        testService.test2();
    }
}
