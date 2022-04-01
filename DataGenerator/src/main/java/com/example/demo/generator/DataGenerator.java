package com.example.demo.generator;

import com.example.demo.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

@Component
@EnableScheduling
public class DataGenerator {

    @Autowired
    KafkaTemplate<String, Data> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String topic;

    private final Random random = new Random();

    @Scheduled(fixedRate = 1000L)
    public void generateData() {
        ZonedDateTime startTime = ZonedDateTime.now();

        int homeTeamId = random.nextInt(10) + 1;
        int awayTeamId = random.nextInt(10) + 1;
        UUID providerId = UUID.randomUUID();
        if (homeTeamId == awayTeamId) {
            return;
        }
        Data data = new Data(providerId,
                homeTeamId,
                awayTeamId,
                startTime.plusHours(random.nextInt(48)),
                1,
                1,
                1,
                random.nextDouble(3) + 1,
                random.nextDouble(3) + 1,
                random.nextDouble(3) + 1);
        kafkaTemplate.send(topic, "key", data);
        System.out.println("Sent successfully");

    }
}
