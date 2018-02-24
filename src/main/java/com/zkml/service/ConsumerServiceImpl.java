package com.zkml.service;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;

public class ConsumerServiceImpl implements ConsumerService {
    private JmsTemplate jmsTemplate;
    private Destination destination;

    /**
     * @return the jmsTemplate
     */
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    /**
     * @param jmsTemplate the jmsTemplate to set
     */
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public void receive() {
        MapMessage message = (MapMessage) jmsTemplate.receive();
        try {
            System.out.println("--收到消息：" + new Date(message.getLong("count")));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
