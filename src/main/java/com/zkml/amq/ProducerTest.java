package com.zkml.amq;

import com.zkml.service.ProducerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerTest {
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext( "applicationContext.xml");

    private static void send() {
        ProducerService producerService = (ProducerService) appContext.getBean("producerService");
        producerService.send();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        send();
    }

}
