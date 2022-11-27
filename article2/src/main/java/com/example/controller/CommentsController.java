package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.entity.Articles;
import com.example.entity.Comments;
import com.example.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/comments")
@Api(tags = "评论管理接口",value = "评论管理")

public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @ApiOperation("根据博文id查询全部评论接口")
    @GetMapping("/getCommentsForId/{id}")
    public ResultVo getCommentsForId(@PathVariable("id")Integer id){
        ResultVo resultVo = commentsService.getCommentsForId(id);
        return resultVo;
    }

    @ApiOperation("根据用户昵称查询全部评论接口")
    @GetMapping("/getCommentsForNickname/{nickname}")
    public ResultVo getCommentsForNickname(@PathVariable("nickname")String nickname){
        ResultVo resultVo = commentsService.getCommentBynickname(nickname);
        return resultVo;
    }

    @ApiOperation("查询用户评论")
    @GetMapping("/getCommentForUser")
    public ResultVo getCommentForUser(){
        ResultVo resultVo = commentsService.getcomments();
        return resultVo;
    }

    @ApiOperation("添加评论接口")
    @PostMapping("/addComment")
    @ResponseBody
    public ResultVo addComment(@RequestBody Comments comments){
        return  commentsService.addcomments(comments);
    }

    @ApiOperation("删除评论接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id", value = "评论id",dataTypeClass = Long.class,required = true),
    })
    @DeleteMapping ("/delComment/{id}")
    public ResultVo delComment(@PathVariable("id")Integer id){
        return  commentsService.delcomments(id);
    }

}

