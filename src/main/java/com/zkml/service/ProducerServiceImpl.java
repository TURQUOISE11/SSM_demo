package com.zkml.service;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
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
    public void send() {
        MessageCreator messageCreator = new MessageCreator(){

            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                Date date = new Date();
                message.setLong("count", date.getTime());
                System.out.println("--发送消息："+date);
                return message;
            }
        };
        jmsTemplate.send(this.destination,messageCreator);

    }
}
