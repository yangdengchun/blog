package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
public interface UserService extends IService<User> {
    ResultVo checkLogin(String name, String pwd);
    ResultVo userRegister(String name, String pwd);

    ResultVo getUsers();

    ResultVo addUser(@Param("User1") User user);

    ResultVo delUser(@Param("id")Integer id);

    ResultVo getUserByname(@Param("name1") String name);

}
