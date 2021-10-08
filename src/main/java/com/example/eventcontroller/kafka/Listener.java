package com.example.eventcontroller.kafka;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Listener {

    public static final Logger logger = LoggerFactory.getLogger(Listener.class);
    
    public Map<String, Object> deserializeEventMessage(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message, HashMap.class);
    }

}
