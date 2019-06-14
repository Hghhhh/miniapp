package com.huyaminiapp.demo;

import com.huyaminiapp.demo.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        JwtUtil.issueJwt((int)(System.currentTimeMillis()/1000));
        SpringApplication.run(DemoApplication.class, args);
    }

    //每18分鐘一次執行一次
    @Scheduled(fixedRate=60000*18)
    public void refreshToken(){
        JwtUtil.issueJwt((int)(System.currentTimeMillis()/1000));
    }

}
