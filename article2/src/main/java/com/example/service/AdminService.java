package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
public interface AdminService extends IService<Admin> {
    ResultVo checkAdmin(String username, String password);
}
