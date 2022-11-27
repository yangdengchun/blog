package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.utils.MD5Utils;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public ResultVo userRegister(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("user_name",name);//相当于where id=1
            List<User> users = userMapper.selectList(wrapper);
            System.out.println(users);
            //2.如果没有被注册则进行保存操作
            if (users.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                User user = new User();
                user.setUserName(name);
                user.setUserNickname("wanl");
                user.setUserPassword(md5Pwd);
                user.setUserProfilePhoto("img/default.jpg");
                user.setUserEmail("3152372110@qq.com");
                user.setUserTelephoneNumber(12345679);
                user.setUserRegistrationTime(new Date());

                int i = userMapper.insert(user);//主键回旋，附带id一起返回
                if (i > 0) {
                    return new ResultVo(ResultStatus.OK, "注册成功", user);
                } else {
                    return new ResultVo(ResultStatus.NO, "注册失败，信息不全", null);
                }
            } else {
                return new ResultVo(ResultStatus.NO, "注册失败，用户名已存在", null);
            }
        }
    }


    @Override
    public ResultVo checkLogin(String name, String pwd) {
        //根据条件查询用户
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name",name);//相当于where id=1
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
        System.out.println(pwd);
        if (users.size() == 0) {
            return new ResultVo(ResultStatus.NO, "登录失败，用户名不存在", null);
        } else {
            String md5Pwd = MD5Utils.md5(pwd);
            if (md5Pwd.equals(users.get(0).getUserPassword())) {
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();         //JWT生成token
                String token = builder.setSubject(name)                //设置token携带的数据
                        .setIssuedAt(new Date())                       //设置token生成时间
                        .setId(users.get(0).getUserId() + "")          //设置用户id为tokenid
                        .setClaims(map)              //封装payload信息       //存放用户角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))//设置过期时间
                        .signWith(SignatureAlgorithm.HS256, "123456")//设置加密方式和加密密码
                        .compact();//返回token
//String token = Base64Utils.encode(name + 123456);
                return new ResultVo(ResultStatus.OK, token, users.get(0));
            } else {
                return new ResultVo(ResultStatus.NO, "登录失败,密码错误", null);
            }
        }
    }

    @Override
    public ResultVo getUsers() {
        List<User> users = userMapper.getUsers();
        return new ResultVo(ResultStatus.OK,"查询成功",users);
    }

    @Override
    public ResultVo addUser(User user) {
        userMapper.addUser(user);
        return new ResultVo(ResultStatus.OK,"添加成功",null);
    }

    @Override
    public ResultVo delUser(Integer id) {
        userMapper.delUser(id);
        return new ResultVo(ResultStatus.OK,"删除成功",null);
    }

    @Override
    public ResultVo getUserByname(String name) {
        User userByname = userMapper.getUserByname(name);
        System.out.println(userByname);
        return new ResultVo(ResultStatus.OK,"查询成功",userByname);
    }
}
