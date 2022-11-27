package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.service.AdminService;
import com.example.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员登录接口",value = "提供用户的登录和注册接口")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username", value = "用户登录账号",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name = "password", value = "用户登录密码",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/login")
    public ResultVo login(@Param(value = "username") String username,
                          @Param(value = "password") String password,
                          HttpSession session,
                          RedirectAttributes attributes){
        ResultVo resultVO = adminService.checkAdmin(username, password);
        return resultVO;
    }
}

