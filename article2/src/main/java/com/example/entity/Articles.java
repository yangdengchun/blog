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

/**
 * <p>
 * 博文表
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Articles对象", description="博文表")
public class Articles implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "博文id")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "发表用户id")
    private Long userId;

    @ApiModelProperty(value = "图片")
    private String articlePicture;

    @ApiModelProperty(value = "博文标题")
    private String articleTitle;

    @ApiModelProperty(value = "博文内容")
    private String articleContent;

    @ApiModelProperty(value = "浏览量")
    private Long articleViews;

    @ApiModelProperty(value = "评论数")
    private Long articleCommentCount;

    @ApiModelProperty(value = "点赞数")
    private Long articleLikeCount;

    @ApiModelProperty(value = "发表时间")
    private Date articleDate;

    @ApiModelProperty(value = "更新时间")
    private Date articleUpdate;

    @ApiModelProperty(value = "分类列表")
    private List<Category> categoryList;

    @ApiModelProperty(value = "用户")
    private User user;

}
