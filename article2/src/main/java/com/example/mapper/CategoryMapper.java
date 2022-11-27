package com.example.mapper;

import com.example.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 分类表 Mapper 接口
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    /**
     * 增
     * @return
     */
    void saveCategory(@Param("category1") Category category);

    /**
     * 查全部分类
     * @return
     */
    List<Category> getCategory();

    /**
     * 改
     * @param id
     * @param name
     * @return
     */
    void updateCategory(@Param("id")Integer id,@Param("name")String name,@Param("description")String description);

    /**
     * 删
     * @param id
     */
    void deleteCategory(Integer id);

    /**
     * 根据博文id查询标签
     * @param id
     * @return
     */
    Category selectForOne(@Param("id") Integer id);
    /**
     * 根据分类id查询标签
     * @param id
     * @return
     */
    Category selectForCategory(@Param("id") Integer id);
    /**
     * 查询所有
     * @return
     */
    List<Category> selectAll();

    /**
     * 查询前四条
     * @return
     */
    List<Category> selectFour();
}
