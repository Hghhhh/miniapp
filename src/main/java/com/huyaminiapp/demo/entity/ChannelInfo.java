package com.huyaminiapp.demo.entity;

import com.google.gson.internal.LinkedTreeMap;
import lombok.Data;

@Data
public class ChannelInfo {

    //公会号
    private String channelNumber;
    //公会名称
    private String channelName;
    //公会LOGO
    private String channelLogo;
    //true：是白金公会；false：非白金公会
    private boolean isPlaintum;
    //公会描述
    private String channelDesc;

    public static  ChannelInfo getChannelInfoFromMap(LinkedTreeMap linkedTreeMap){
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setChannelDesc((String) linkedTreeMap.get("channelDesc"));
        channelInfo.setChannelLogo((String) linkedTreeMap.get("channelLogo"));
        channelInfo.setChannelName((String)linkedTreeMap.get("channelName"));
        channelInfo.setChannelNumber( linkedTreeMap.get("channelNumber").toString());
        channelInfo.setPlaintum((Boolean) linkedTreeMap.get("isPlaintum"));
        return channelInfo;
    }

}
