package com.yy.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yy.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping(value = "/test")
    public String test(){
        return helloService.sayHello(":老王,今晚吃啥?");
    }

//    @RequestMapping(value = "/test01")
    @GetMapping(value = "/test01")
    public String to() {
        return "hello";
    }
    @RequestMapping(value = "/users")
    public String findUsers() {
        String user = helloService.findUser();
        return user.toString();
    }
    @RequestMapping(value = "/update")
    public String uUser() {
        String str = helloService.updateUser();
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "update success";
        }
        return "update fail";
    }
    @RequestMapping(value = "/insert")
    public String insertUser() {
        String str = helloService.createUser();
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "insert success";
        }
        return "insert fail";
    }
    @RequestMapping(value = "/delete")
    public String deletetUser() {
        String str = helloService.userDelete(7);
        int n = Integer.parseInt(str);
        if (n == 1) {
            return "delete success";
        }
        return "delete fail";
    }
@RequestMapping(value = "/select/{id}")
    public String selectUserById(@PathVariable("id") Integer id) {
//        System.out.println("-----id-----"+id);
        String str = helloService.selectById(id);
        return str.toString();
    }


}
