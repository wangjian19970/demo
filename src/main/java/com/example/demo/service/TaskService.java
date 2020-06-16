package com.example.demo.service;

import lombok.extern.log4j.Log4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class TaskService {
    public static void getAddr() {
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void getAddr1()throws InterruptedException{
        //todo 10分钟
        Thread.sleep(2000);
        log.info("-------------任务一-------------");
    }
   @Async
    @Scheduled(fixedRate = 1000)
    public void getAddr2()throws InterruptedException{
        //todo 10分钟
        Thread.sleep(4000);
        log.info("-------------任务二-------------");
    }
    @Async
    @Scheduled(fixedRate = 1000)
    public void getAddr3()throws InterruptedException{
        //todo 10分钟
        Thread.sleep(3000);
        log.info("-------------任务三-------------");
    }
}
