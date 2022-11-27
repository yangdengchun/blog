package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> getUsers();

    void addUser(@Param("User1") User user);

    void delUser(@Param("id")Integer id);

    /**
     * 模糊查询姓名
     * @param name
     * @return
     */
    User getUserByname(@Param("name1")String name);

}
