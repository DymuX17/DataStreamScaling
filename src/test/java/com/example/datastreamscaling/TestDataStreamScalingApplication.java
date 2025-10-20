package com.example.datastreamscaling;

import org.springframework.boot.SpringApplication;

public class TestDataStreamScalingApplication {

    public static void main(String[] args) {
        SpringApplication.from(DataStreamScalingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
