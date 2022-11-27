package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户好友表
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserFriends对象", description="用户好友表")
public class UserFriends implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标识id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "好友id")
    private Long userFriendsId;

    @ApiModelProperty(value = "好友备注")
    private String userNote;

    @ApiModelProperty(value = "好友状态")
    private String userStatus;


}
