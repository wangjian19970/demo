package com.example.demo.controller;

import com.example.demo.service.KnightService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Log4j
@RestController
@RequestMapping(value = "/ios")
public class IosController {
    @Autowired
    private KnightService knightService;
    //@GetMapping(value = "getAddr")
   // @Scheduled(fixedRate = 1000)，1000毫秒跳一次
    //@Scheduled(cron = "2 * * * * ? ")
    //public  void getAddr(){

      //  log.info(knightService.getAddr());
    //}

}
