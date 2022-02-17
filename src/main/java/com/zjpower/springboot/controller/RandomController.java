package com.zjpower.springboot.controller;

import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomController {

    @Autowired
    RandomService randomService;

    @GetMapping(value = "/lanjie/randomAdd")
    public ResultDto randomSum(){
        ResultDto sum = randomService.randomSum();
        return sum;
    }
}
