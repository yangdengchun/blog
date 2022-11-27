package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.entity.Comments;
import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
*/
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理",value = "提供用户的登录和注册接口")
public class UserController {

    @Resource
    private UserService userService;


    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/login")
    public ResultVo login(@RequestParam(value = "username") String name,
                          @RequestParam(value = "password") String pwd){
        ResultVo resultVO = userService.checkLogin(name, pwd);
        return resultVO;
    }
    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户注册账号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户注册密码",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/regist")
    public ResultVo regist(@RequestParam(value = "username")String username,
                           @RequestParam(value = "password")String password){
        ResultVo resultVo = userService.userRegister(username, password);
        return resultVo;
    }
    @ApiOperation("查询全部用户接口")
    @GetMapping("/getUser")
    public ResultVo getUser(){
        ResultVo resultVo = userService.getUsers();
        return resultVo;
    }

    @ApiOperation("根据用户昵称查询全部用户接口")
    @GetMapping("/getUserBynickname/{nickname}")
    public ResultVo getUserBynickname(@PathVariable("nickname") String nickname){
        ResultVo resultVo = userService.getUserByname(nickname);
        return resultVo;
    }

    @ApiOperation("添加用户接口")
    @PostMapping("/addUser")
    @ResponseBody
    public ResultVo addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    @ApiOperation("删除用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id", value = "用户id",dataTypeClass = Long.class,required = true),
    })
    @DeleteMapping ("/delUser/{id}")
    public ResultVo delUser(@PathVariable("id")Integer id){
        return  userService.delUser(id);
    }

}
