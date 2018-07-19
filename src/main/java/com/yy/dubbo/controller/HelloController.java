package com.yy.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yy.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/test")
    public String test(){
        return helloService.sayHello(":老王,今晚吃啥?");
    }

    @RequestMapping("/test01")
    public String to() {
        return "hello";
    }
    @RequestMapping("/users")
    public String findUsers() {
        String user = helloService.findUser();
        return user.toString();
    }
    @RequestMapping("/update")
    public String uUser() {
        String str = helloService.updateUser();
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "update success";
        }
        return "update fail";
    }
    @RequestMapping("/insert")
    public String insertUser() {
        String str = helloService.createUser();
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "insert success";
        }
        return "insert fail";
    }
    @RequestMapping("/delete")
    public String deletetUser() {
        String str = helloService.userDelete(7);
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "delete success";
        }
        return "delete fail";
    }
}
