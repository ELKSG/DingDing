package com.example.dingding.controller;

import com.example.dingding.entity.CodeMsg;
import com.example.dingding.service.TestService;
import com.example.dingding.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permit-through/")
public class DingDingController {

    @Resource
    private TestService testService;

    @GetMapping("/testw")
    public Result test() {
        testService.test();
        return new Result(CodeMsg.FILES);
    }

}
