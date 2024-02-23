package com.example.dingding.controller;

import com.example.dingding.utils.Result;
import com.example.dingding.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@RequestMapping("/login/")
public class WXController {
    @ApiOperation(value = "根据额度ID获取信息")
    @RequestMapping(value = "/wx", method = RequestMethod.POST)
    @ResponseBody
    public Result wx(@ApiParam(required = true, value = "额度查询ID") @RequestParam("id") String id){
        try {
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error(101,"请联系管理员");
        }
    }
    @Test
    public void ads(){
        int max=1;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
    }
}
