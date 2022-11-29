package com.example.resmanger.entity;

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
 * 
 * </p>
 *
 * @author ydc
 * @since 2022-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Model对象", description="")
public class Model implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限ID")
    @TableId(value = "model_id", type = IdType.AUTO)
    private Integer modelId;

    @ApiModelProperty(value = "权限名称")
    private String modelName;


}
