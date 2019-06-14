package com.huyaminiapp.demo.entity;

import com.google.gson.internal.LinkedTreeMap;
import lombok.Data;

import java.util.List;

@Data
public class CommandResult {

    //对应的命令（订阅/取消订阅），subscribeNotice：订阅； unsubscribeNotice：取消订阅
    private String command;

    //command执行操作的对应的开放平台开放的接口数组
    private List<String> data;

    //当ret等于1 部分失败时对应data中的失败列表
    private List<String> failedList;

    //客户端command请求的唯一标识，客户端生成的，服务器回填，用于标识某一次comman请求与对应的请求rsp
    private String reqId;

    //错误码，命令执行的返回码，全部成功为0，部分成功为1，全部失败为-1；
    private int ret;

    //对应ret的msg信息
    private String msg;

    public static CommandResult getInstance(LinkedTreeMap linkedTreeMap){
        CommandResult commandResult = new CommandResult();
        commandResult.setCommand((String) linkedTreeMap.get("command"));
        commandResult.setData((List<String>) linkedTreeMap.get("data"));
        commandResult.setFailedList((List<String>) linkedTreeMap.get("failedList"));
        commandResult.setMsg((String) linkedTreeMap.get("msg"));
        commandResult.setReqId((String) linkedTreeMap.get("reqId"));
        commandResult.setRet((Integer) linkedTreeMap.get("ret"));
        return commandResult;
    }

}
