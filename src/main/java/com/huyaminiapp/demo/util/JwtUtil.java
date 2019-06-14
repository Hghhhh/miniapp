package com.huyaminiapp.demo.util;
import com.huyaminiapp.demo.entity.JwtToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String appId = "9ac96494004ce9d9";

    private static final String secret = "6825023afb5ebe9799bb5153490402d4";

    private static JwtToken jwtToken;

    public static JwtToken getJwtToken(){
        return jwtToken;
    }

    /**
     * JWT token 生成
     * @return
     */
    public static String issueJwt(int curTime) {
        Map<String, Object> stringObjectMap = new HashMap<>(2);
        stringObjectMap.put("alg", "HS256");
        stringObjectMap.put("typ", "JWT");
        int expTime = curTime+1200;
        String payload = "{\"iat\":"+ curTime + ",\"exp\":"+ expTime +",\"appId\":\""+appId+"\"}";
        String token = Jwts.builder().setHeader(stringObjectMap)
                .setPayload(payload).signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();
        JwtToken jwtToken = new JwtToken();
        jwtToken.setCurTime(curTime);
        jwtToken.setExpTime(expTime);
        jwtToken.setToken(token);
        JwtUtil.jwtToken = jwtToken;
        return token;
    }

}
