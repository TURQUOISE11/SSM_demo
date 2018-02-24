package com.zkml.controller;

import com.zkml.bean.Student;
import com.zkml.service.StudentService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestController implements Runnable{
    @Autowired
    private StudentService studentService;

    //   private static String topic = "$share/testgroup/wyptest1";
//   private static String topic = "$queue/wyptest1";
//   private static String topic = "wyptest1";
    private static int qos = 2;
    private static String broker = "tcp://10.100.124.207:1883";
    private static String userName = "tuyou";
    private static String passWord = "tuyou";


    private static MqttClient connect(String clientId) throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttConnectOptions connOpts = new MqttConnectOptions();
//       String[] uris = {"tcp://10.100.124.206:1883","tcp://10.100.124.206:1883"};
        connOpts.setCleanSession(false);
        connOpts.setUserName(userName);
        connOpts.setPassword(passWord.toCharArray());
        connOpts.setConnectionTimeout(10);
        connOpts.setKeepAliveInterval(20);
//         connOpts.setServerURIs(uris);
//         connOpts.setWill(topic, "close".getBytes(), 2, true);
        MqttClient mqttClient = new MqttClient(broker, clientId, persistence);
        mqttClient.connect(connOpts);
        return mqttClient;
    }

    public static void sub(MqttClient mqttClient,String topic) throws MqttException{
        int[] Qos  = {qos};
        String[] topics = {topic};
        mqttClient.subscribe(topics, Qos);
    }


    private static void runsub(String clientId, String topic) throws MqttException{
        MqttClient mqttClient = connect(clientId);
        if(mqttClient != null){
            sub(mqttClient,topic);
        }
    }
/*    @Test
    public void test1(){
        //获取上下文对象
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        TestController testController =(TestController)context.getBean("testController");

//     Student student = newStudent("002","小明","男",20);
//     studentAction.studentService.save(student);
        Student std = testController.studentService.getStudent("001");
        System.out.println(std);
    }*/

    public static void main(String[] args) throws MqttException {
        //获取上下文对象
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");

            TestController testController =(TestController)context.getBean("testController");
        for (int i=0;i<5;i++){
//     Student student = newStudent("002","小明","男",20);
//     studentAction.studentService.save(student);
            testController.run();
            /*Integer std = testController.studentService.getStudent("001");
            System.out.println((i+1)+":"+std);*/
        }

    }

    @Override
    public void run() {
        try {
            runsub("client-id-1", "$share/testgroupa/edge/server/private/+");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

