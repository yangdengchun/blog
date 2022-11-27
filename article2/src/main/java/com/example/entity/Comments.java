package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.stream.events.Comment;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comments对象", description="评论表")
public class Comments implements Serializable {

    private static final long serialVersionUID=12L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @ApiModelProperty(value = "发表用户id")
    private Long userId;

    @ApiModelProperty(value = "评论文章id")
    private Long articleId;

    @ApiModelProperty(value = "点赞数")
    private Long commentLikeCount;

    @ApiModelProperty(value = "评论内容")
    private String commentContent;

    @ApiModelProperty(value = "评论日期")
    private Date commentDate;

    @ApiModelProperty(value = "父评论id")
    private Long parentCommentId;

    @ApiModelProperty(value = "用户")
    private User user;

    @ApiModelProperty(value = "博文")
    private Articles articles;

    @ApiModelProperty(value = "用户")
    private List<User> userList;




}
