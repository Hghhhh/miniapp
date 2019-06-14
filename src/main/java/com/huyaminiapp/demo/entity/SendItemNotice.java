package com.huyaminiapp.demo.entity;

import lombok.Data;

@Data
public class SendItemNotice {

    private String itemName;

    private String unionId;

    private String presenterNick;

    private int roomId;

    // 送礼连击数
    private int sendItemComboHits;

    private int sendItemCount;

    private String sendNick;

    private String senderAvatarurl;

}
