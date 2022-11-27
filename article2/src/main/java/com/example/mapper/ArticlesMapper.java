package com.example.mapper;

import com.example.entity.Articles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Labels;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 博文表 Mapper 接口
 * </p>
 *
 * @author ydc
 * @since 2022-09-20
 */
@Mapper
public interface ArticlesMapper extends BaseMapper<Articles> {
    /**
     * 增
     * @param article
     */
    void addArticles(@Param("article") Articles article);

    /**
     * 改
     * @param id
     * @param articles
     */
    void updateArticles(@Param("id")Integer id,@Param("article")Articles articles);

    /**
     * 删
     * @param id
     */
    void delArticles(@Param("id")Integer id);

    /**
     * 查
     * @return
     */
    List<Articles> getArticles();

    /**
     * 分页查
     * @return
     */
    List<Articles> selectPage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /**
     * 根据id查
     * @param id
     * @return
     */
    Articles getArticlesById(@Param("id")Integer id);

    /**
     * 查询所有帖子信息和对应的分类信息
     */
    List<Articles> selectAll();
    /**
     * 通过id查询帖子信息和对应的分类信息
     */
    Articles selectOne(@Param("id") Integer id);

}
