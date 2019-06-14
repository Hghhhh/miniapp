package com.huyaminiapp.demo.service;

import cn.hutool.json.JSONUtil;
import com.huyaminiapp.demo.dto.Command;
import com.huyaminiapp.demo.dto.WebSocketCommandResult;
import com.huyaminiapp.demo.entity.CommandResult;
import com.huyaminiapp.demo.entity.JwtToken;
import com.huyaminiapp.demo.util.JwtUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SubscribeService {

    private static final String SUBSCRIBENOTICE = "subscribeNotice";

    private static final String UNSUBSCRIBENOTICE = "unsubscribeNotice";


    @Value("${huyaminiapp.appId}")
    private String appId;

    private ConcurrentHashMap<Integer,WebSocketClient> socketClientMap = new ConcurrentHashMap<>();

    /**
     * 发送心跳
     */
    @Scheduled(fixedRate=15000)
    public void ping(){
        //遍历值
        for(WebSocketClient value : socketClientMap.values()) {
            value.sendPing();
        }
    }

    public void createWebSocket(int roomId, List<String> subNoices){
        try {
            JwtToken jwtToken = JwtUtil.getJwtToken();
            String url = "ws://ws-apiext.huya.com/index.html?do=comm&roomId="+roomId+"&appId="+appId+"&iat="+jwtToken.getCurTime()+"&sToken="+jwtToken.getToken();
            URI uri = new URI(url);
            WebSocketClient socket = new WebSocketClient(uri){
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    //发送subscribeNotice command
                    Command command = new Command();
                    command.setCommand(SUBSCRIBENOTICE);
                    command.setData(subNoices);
                    command.setReqId(UUID.randomUUID().toString());
                    this.send(JSONUtil.parseObj(command).toString());

                }

                @Override
                public void onMessage(String s) {
                    WebSocketCommandResult webSocketCommandResult = JSONUtil.toBean(s,WebSocketCommandResult.class);
                    switch (webSocketCommandResult.getNotice()){
                        case "command":
                            CommandResult commandResult = CommandResult.getInstance(webSocketCommandResult.getData());
                            System.out.println(commandResult.getCommand()+commandResult.getData()+commandResult.getMsg()+commandResult.getReqId()+commandResult.getFailedList()+commandResult.getRet());
                            break;
                        case "getMessageNotice":break;
                        case "getSendItemNotice": break;
                        case "getVipEnterBannerNotice": break;
                        default:
                    }
                }

                @Override
                public void onClose(int i, String s, boolean b) {

                }

                @Override
                public void onError(Exception e) {

                }
            };
            socket.connect();
            System.out.println(222222);
            socketClientMap.put(roomId,socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
