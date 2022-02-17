package com.zjpower.springboot.service.impl;

import com.zjpower.springboot.dto.ResultDto;
import com.zjpower.springboot.service.RandomService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomServiceImpl implements RandomService {
    @Override
    public ResultDto randomSum() {
        Random random = new Random();
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            int a = random.nextInt(10) + 1;   //表示范围[1 -101)
//            System.out.println("生成的第" + i + "个数为：" + a);
            sum = sum + a;
        }
//        System.out.println("生成的随机数和为：" + sum);
        ResultDto result = new ResultDto();
        result.setData(sum);
        return result;
    }
}
