package com.huyaminiapp.demo.entity;

import lombok.Data;

@Data
public class MessageNotice {

    //粉丝徽章名称
    private String badgeName;

    //弹幕内容
    private String content;

    //粉丝等级
    private int fansLevel;

    //贵族等级
    private int nobleLevel;

    //unionId为用户唯一的加密字符串Id
    private String unionId;

    //房间号
    private int roomId;

    //发送弹幕的用户昵称
    private String sendNick;

    //发送弹幕的用户头像
    private String senderAvatarUrl;

    //发送弹幕的用户性别
    private int senderGender;

    private int showMode;
}
