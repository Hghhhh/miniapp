package com.huyaminiapp.demo;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.huyaminiapp.demo.dto.Result;
import com.huyaminiapp.demo.entity.ChannelInfo;
import com.huyaminiapp.demo.entity.JwtToken;
import com.huyaminiapp.demo.service.ChannelInfoService;
import com.huyaminiapp.demo.service.SubscribeService;
import com.huyaminiapp.demo.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private ChannelInfoService channelInfoService;

    @Autowired
    private SubscribeService subscribeService;


    @Test
    public void contextLoads() {
        JwtUtil.issueJwt((int)(System.currentTimeMillis()/1000));
        ResponseEntity<Result> r  = channelInfoService.getChannelInfo("9ac96494004ce9d9",520520,"6825023afb5ebe9799bb5153490402d4");
        ChannelInfo channelInfo = ChannelInfo.getChannelInfoFromMap(r.getBody().getData());
        System.out.println(channelInfo.getChannelDesc()+channelInfo.getChannelLogo()+channelInfo.getChannelName()+channelInfo.getChannelNumber());
    }

    @Test
    public void testJwt(){
        int t = (int)(System.currentTimeMillis()/1000);
        System.out.println(t);
    // String s = JwtUtil.issueJwt("9ac96494004ce9d9","6825023afb5ebe9799bb5153490402d4",t);
      //  System.out.println(s);
    }

    @Test
    public  void testSubSer() throws InterruptedException {
        JwtUtil.issueJwt((int)(System.currentTimeMillis()/1000));
        List<String> list = new ArrayList<>();
        list.add("getMessageNotice");
        subscribeService.createWebSocket(520520,list);
        TimeUnit.MINUTES.sleep(1);
    }

}
