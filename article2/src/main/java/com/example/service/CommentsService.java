package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
public interface CommentsService extends IService<Comments> {
    /**
     * 查
     * @return
     */
    ResultVo getcomments();

    /**
     * 通过用户昵称查找评论
     * @param nickname
     * @return
     */
    ResultVo getCommentBynickname(String nickname);

    ResultVo getCommentsForId(Integer id);

    ResultVo addcomments(Comments comments);

    ResultVo delcomments(Integer id);
}
