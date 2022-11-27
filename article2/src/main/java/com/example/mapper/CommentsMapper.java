package com.example.mapper;

import com.example.entity.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
    /**
     * 查
     * @return
     */
    List<Comments> getcomments();

    /**
     * 根据昵称查询所有评论
     * @param nickname
     * @return
     */
    List<Comments> getCommentBynickname(@Param("nickname")String nickname);

    /**
     * 查
     * @return
     */
    List<Comments> getCommentsForId(@Param("id")Integer id);

    ///**
    // * 根据用户id查询用户昵称
    // * @param id
    // * @return
    // */
    //List<Comments> getNicknameForUserId(@Param("id")Integer id);

    void addcomments(@Param("comments1") Comments comments);

    void delcomments(@Param("id")Integer id);
}
