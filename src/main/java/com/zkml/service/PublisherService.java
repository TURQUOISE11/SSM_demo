package com.zkml.service;

public interface PublisherService {
    /**
     * 发送方法
     */
    public void send();

    public void convertAndSend(Object obj);

}
