package com.qcxy.demo.controller;

import com.qcxy.demo.Test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("testB")
    public Test test(@RequestBody Test t){
        return t.setA(100).setB(11000);
    }
}
