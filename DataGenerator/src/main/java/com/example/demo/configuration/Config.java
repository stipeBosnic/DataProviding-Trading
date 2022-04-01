package com.example.demo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {

    @Bean
    NewTopic data() {
        System.out.println("new topic");
        return TopicBuilder.name("data").partitions(12).replicas(1).compact().build();
    }
}
