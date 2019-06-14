package com.huyaminiapp.demo.service;

import com.huyaminiapp.demo.dto.Result;
import com.huyaminiapp.demo.entity.JwtToken;
import com.huyaminiapp.demo.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelInfoService {
    private RestTemplate restTemplate = new RestTemplate();
    private  StringBuffer url = new StringBuffer("https://open-apiext.huya.com/channel/index?do=getChannelInfoByRoom");

    public ResponseEntity<Result> getChannelInfo(String appId, Integer roomId, String secret){
        JwtToken jwtToken = JwtUtil.getJwtToken();
        url.append("&appId="+appId);
        url.append("&roomId="+roomId);
        url.append("&iat="+jwtToken.getCurTime());
        url.append("&exp="+jwtToken.getExpTime());
        url.append("&sToken="+jwtToken.getToken());
        ResponseEntity<Result> r = restTemplate.getForEntity(url.toString(),Result.class);
        return r;
    }
}
