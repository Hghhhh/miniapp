package com.huyaminiapp.demo.entity;

import lombok.Data;

@Data
public class JwtToken {

    private String token;
    private int curTime;
    private int expTime;
}
