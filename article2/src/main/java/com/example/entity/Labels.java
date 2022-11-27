package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 标签表
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Labels对象", description="标签表")
public class Labels implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标签id")
    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @ApiModelProperty(value = "标签别名")
    private String labelAlias;

    @ApiModelProperty(value = "标签描述")
    private String labelDescription;

    @ApiModelProperty(value = "创建时间")
    private Date labelDate;

    private List<Articles> articlesList;


}
