package com.cath.cathdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootTest
class CathDemoApplicationTests {

    @Test
    void contextLoads() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sTime = now.minusDays(1);

        long duration = Duration.between(sTime, now).toHours();

        for (int i = 0; i < duration; i++){
            LocalDateTime ssTime = sTime.plusHours(i);
            LocalDateTime endTime = sTime.plusHours(i + 1);
            System.out.println("開始時間:"+ssTime+"\t結束時間:"+endTime);
        }
        System.out.println("====over");
    }

}
