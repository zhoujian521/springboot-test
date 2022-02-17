package com.zjpower.springboot.service.impl;

import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public ResultDto calculate(Double a, Double b, String c) {
        ResultDto result = new ResultDto();
        double res = 0;
        switch (c) {
            case "add":
                res = a + b;
                break;
            case "sub":
                res = a - b;
                break;
            case "multi":
                res = a * b;
                break;
            case "div":
                res = a / b;
                break;
            default:
                result.setCode(1002);
                result.setMsg("参数异常, c参数为add(+) | sub(-) | multi(*) | div(/) 其中之一");
                break;
        }
        result.setData(res);
        return result;
    }
}


