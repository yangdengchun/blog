package com.example.mapper;

import com.example.entity.SetCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@Mapper
public interface SetCategoryMapper extends BaseMapper<SetCategory> {

    void setCategoryForArticle(@Param("articleId")Integer articleId,@Param("categoryName")String categoryName);
}
