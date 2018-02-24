package com.zkml.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class SubscriberListenerServiceImpl implements SubscriberListenerService {
    @Override
    public void receive(HashMap message) {
        System.out.println("--订阅者一Listener收到消息：" + new Date(new Long((Long) message.get("count"))));
    }
}
