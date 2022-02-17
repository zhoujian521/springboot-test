package com.zjpower.springboot.controller;

import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CalculateController {

    @Autowired
    CalculateService calculateService;

    @PostMapping(value = "/calculate")
    public ResultDto calculate(Double a, Double b, String c) {
        ResultDto result = new ResultDto();
        if (Objects.isNull(a) || Objects.isNull(b)){
            result.setCode(1001);
            result.setMsg("参数异常, 参数a 参数b 不可以为null");
            return result;
        };
        if (Objects.isNull(c)) {
            c = "add";
        }
        ResultDto res = calculateService.calculate(a, b, c);
        return res;
    }
}
