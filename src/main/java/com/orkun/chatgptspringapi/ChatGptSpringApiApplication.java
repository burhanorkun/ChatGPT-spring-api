package com.orkun.chatgptspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChatGptSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatGptSpringApiApplication.class, args);
    }

}
