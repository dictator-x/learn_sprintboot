package com.learnspringboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "0,1,2,3,4 * * * * *")
    public void hello() {
        System.out.println("cron hello....");
    }
}
