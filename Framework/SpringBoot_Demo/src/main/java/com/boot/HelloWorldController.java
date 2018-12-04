package com.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RestController: controller 里面的方法, 都以json格式输出, 不用再写什么jackjson配置的了
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "HelloWorld";
    }

}
// http://localhost:8080/helloWorld

// 1.Application.java 建议放到跟目录下面, 主要用于做一些框架配置

// 2.domain 目录主要用于实体（Entity）与数据访问层（Repository）

// 3.service 层主要是业务类代码

// 4.controller 负责页面访问控制