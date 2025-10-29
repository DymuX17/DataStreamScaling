package com.example.producer.controller;

import com.example.producer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private static final String TOPIC = "orders";
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @PostMapping
    public String postOrder(@RequestBody Order order) {
        kafkaTemplate.send(TOPIC, order.getOrderId(), order);
        return "Order sent to Kafka topic!";
    }

}
