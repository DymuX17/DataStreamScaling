package com.example.consumer.service;


import com.example.common.kafka.Topics;
import com.example.common.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    @KafkaListener(topics = Topics.ORDERS, groupId = "order-consumer")
    public void receiveOrder(Order order) {
        log.info("Received order: {}", order);
    }
}
