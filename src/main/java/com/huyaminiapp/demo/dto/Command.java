package com.huyaminiapp.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class Command {

    private String command;

    private List<String> data;

    private  String reqId;


}
