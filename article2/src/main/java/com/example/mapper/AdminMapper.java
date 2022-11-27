package com.example.mapper;

import com.example.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
//检查用户名密码
    public Admin checkname(@Param(value = "username") String username,
                           @Param(value = "password") String password);

}
