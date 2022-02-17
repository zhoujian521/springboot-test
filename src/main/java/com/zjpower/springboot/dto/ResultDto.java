package com.zjpower.springboot.dto;

import lombok.Data;

@Data
public class ResultDto {
    private int code = 200;
    private String msg = "成功";
    private Object data;
}
