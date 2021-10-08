package com.example.eventcontroller.controller;

import com.example.eventcontroller.kafka.KafkaSender;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("request")
public class RequestController {

    private KafkaSender kafkaSender;

    public RequestController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }


    @GetMapping("/enqueue/{topic}")
    public void enqueuToTopic(@RequestBody Map<String, Object> request, @PathVariable("topic") String topic) {
        kafkaSender.sendResponse("", topic, request);
    }
}
