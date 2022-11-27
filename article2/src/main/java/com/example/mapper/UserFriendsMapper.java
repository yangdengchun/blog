package com.example.mapper;

import com.example.entity.UserFriends;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户好友表 Mapper 接口
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Mapper
public interface UserFriendsMapper extends BaseMapper<UserFriends> {

}
