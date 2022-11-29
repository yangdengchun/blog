package com.example.resmanger.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.resmanger.common.ResultStatus;
import com.example.resmanger.common.ResultVo;
import com.example.resmanger.entity.User;
import com.example.resmanger.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ydc
 * @since 2022-11-19
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口",value = "用户管理")
public class UserController {
    @Resource
    private UserService userService;


    @ApiOperation("用户查询接口")
    @GetMapping("/one")
    @ResponseBody
    public ResultVo getArticle(){
        User user = userService.test();
        return new ResultVo(ResultStatus.OK,"查询成功",user);

    }
}

