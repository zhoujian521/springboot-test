package com.zjpower.springboot.service;

import com.zjpower.springboot.dto.ResultDto;

public interface CalculateService {
    ResultDto calculate(Double a, Double b, String c);
}
