package com.yiibai.tutorial.spring.helloworld;

public class HelloWorldService {

    // HelloWorldService 是控制“对象创建” Hello World 的
    // 因为有“反转控制”(IOC)的定义
    // 并且IoC容器将充当管理者角色，创建了HelloWorldService 和 HelloWorld

    private HelloWorld helloWorld;

    public HelloWorldService() {

    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

}
