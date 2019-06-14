package com.huyaminiapp.demo.dto;

import com.google.gson.internal.LinkedTreeMap;
import lombok.Data;

@Data
public class Result {

     //接口返回码
    private Integer code;
    //消息提示
    private String message;
    //返回数据
    private LinkedTreeMap data;
}
