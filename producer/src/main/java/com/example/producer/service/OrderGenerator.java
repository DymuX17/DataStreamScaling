package com.example.producer.service;

import com.example.producer.model.Order;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class OrderGenerator {
    private static final String TOPIC = "orders";
    private static final Logger logger = LoggerFactory.getLogger(OrderGenerator.class);

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final Random random = new Random();

    public OrderGenerator(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostConstruct
    public void start() {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Order order = generateRandomOrder();
                logger.info("Sending order to topic: {}: {}", TOPIC, order);
                kafkaTemplate.send(TOPIC, order.getOrderId(), order);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        t.setDaemon(true);
        t.start();

    }

    private Order generateRandomOrder() {
        return new Order(UUID.randomUUID().toString().substring(0, 5),
                "user-" + random.nextInt(10),
                Math.round((10 + random.nextDouble() * 990) * 100.0) / 100.0);
    }

}

