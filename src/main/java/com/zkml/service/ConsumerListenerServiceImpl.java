package com.zkml.service;

import java.util.Date;
import java.util.HashMap;

public class ConsumerListenerServiceImpl implements ConsumerListenerService {
    @Override
    public void receive(HashMap message) {
        System.out.println("--Listener收到消息：" + new Date(new Long((Long) message.get("count"))));
    }
}
