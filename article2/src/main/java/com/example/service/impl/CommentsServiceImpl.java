package com.example.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Comments;
import com.example.mapper.CommentsMapper;
import com.example.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public ResultVo getcomments() {
        List<Comments> getcomments = commentsMapper.getcomments();
        return new ResultVo(ResultStatus.OK,"查询成功",getcomments);
    }

    @Override
    public ResultVo getCommentsForId(Integer id) {
        List<Comments> commentsForId = commentsMapper.getCommentsForId(id);
        return new ResultVo(ResultStatus.OK,"查询成功",commentsForId);
    }

    @Override
    public ResultVo getCommentBynickname(String nickname) {
        List<Comments> commentBynickname = commentsMapper.getCommentBynickname(nickname);
        return new ResultVo(ResultStatus.OK,"查询成功",commentBynickname);
    }

    @Override
    public ResultVo addcomments(Comments comments) {
        commentsMapper.addcomments(comments);
        return new ResultVo(ResultStatus.OK,"添加成功",null);
    }

    @Override
    public ResultVo delcomments(Integer id) {
        commentsMapper.delcomments(id);
        return new ResultVo(ResultStatus.OK,"删除成功",null);
    }
}
