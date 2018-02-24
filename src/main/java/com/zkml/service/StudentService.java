package com.zkml.service;

import com.zkml.bean.Student;
import com.zkml.dao.StudentDao;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void save(Student student) {
        studentDao.save(student);
    }

    public Integer getStudent(String id) {
        Integer student = studentDao.getUser(id);
        return student;
    }

    /*@Override
    public void run() {
        try {
            runsub("client-id-1", "$share/testgroupa/edge/server/private/+");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }*/
  /*  //   private static String topic = "$share/testgroup/wyptest1";
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
    }*/
}