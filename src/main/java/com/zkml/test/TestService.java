package com.zkml.test;

import com.zkml.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {
    @Autowired
    private PublisherService publisherService;
    public void test2(){
        publisherService.send();
    }
}
