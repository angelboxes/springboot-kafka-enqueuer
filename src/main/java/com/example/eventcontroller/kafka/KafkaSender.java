package com.example.eventcontroller.kafka;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {

    public static final Logger logger = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendResponse(String messageKey, String topic, Object response) {
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(response);
        template.send(topic, messageKey, jsonResponse);
    }

}
