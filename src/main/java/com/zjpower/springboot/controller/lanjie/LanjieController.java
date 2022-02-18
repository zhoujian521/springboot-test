package com.zjpower.springboot.controller.lanjie;

import com.zjpower.springboot.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanjieController {

    @GetMapping(value = "/lanjie/abc")
    public ResultDto lanjieTest() {
        ResultDto result = new ResultDto();
        result.setData("路由中包含 /abc && header中包含 key:abc");
        return result;
    }
}