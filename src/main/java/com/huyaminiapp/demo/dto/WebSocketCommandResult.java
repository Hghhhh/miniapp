package com.huyaminiapp.demo.dto;

import com.google.gson.internal.LinkedTreeMap;
import lombok.Data;

@Data
public class WebSocketCommandResult {

    //对应通知类型，command：表示命令回包；getMessageNotice：弹幕事件；getSendItemNotice：送礼事件；getVipEnterBannerNotice：进场事件
    private String notice;

    //data对应的数据根据notice来解析，不同的notice对应不同的结构
    private LinkedTreeMap data;

    //返回码，成功200
    private int statusCode;

    //其他错误返回的描述信息
    private String statusMsg;

}
