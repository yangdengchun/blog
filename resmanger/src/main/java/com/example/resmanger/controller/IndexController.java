package com.example.resmanger.controller;

/**
 * @author ydc
 * @create 2022-11-19 14:21
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页模块
 */
@Api(tags = {"首页模块"})
@RestController
public class IndexController {

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "name", value = "姓名")
    })
    @ApiOperation(value = "", notes = "", httpMethod = "GET")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
        return ResponseEntity.ok("Hi:"+name);
    }
}

