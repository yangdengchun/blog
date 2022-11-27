package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Admin;
import com.example.entity.User;
import com.example.mapper.AdminMapper;
import com.example.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResultVo checkAdmin(String username, String password) {
        Admin admin = adminMapper.checkname(username,password);
        if (admin == null){
            return new ResultVo(ResultStatus.NO,"密码错误","");
        } else if (admin!=null&&admin.getAdminPassword().equals(admin.getAdminPassword())){
            return new ResultVo(ResultStatus.OK,"登录成功",admin);
        }
        return new ResultVo(ResultStatus.NO,"登录失败，用户名不存在","");

    }
}
