package com.huyaminiapp.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class TVAwardNotice {
    //房间号
    private int roomId;

    //房间主播设置的上电视主播
    private String title;

    //房间主播设置的奖品名称
    private String awardName;

    //房间主播设置的上电视最大中奖数量
    private int awardNum;

    //结束时间
    private List<String> awardUserList;

}
