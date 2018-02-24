package com.zkml.service;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {
    JmsTemplate jmsTemplate;

    Destination destination;
    @Override
    public void receive() {
        MapMessage message = (MapMessage) jmsTemplate.receive();
        try {
            System.out.println("--订阅者一收到消息：" + new Date(message.getLong("count")));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
