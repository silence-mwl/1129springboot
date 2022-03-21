package com.zr.controller;

import com.zr.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j // 日志变量
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        User user = new User();
//        user.setName("成龙");
//        user.setAge(10);
        User user1 = User.builder().name("成龙").age(18).build();
        System.out.println(user1);
        log.info("hello这是日志");
        return "hello";
    }
}
