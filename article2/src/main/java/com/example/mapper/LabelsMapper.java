package com.example.mapper;

import com.example.entity.Category;
import com.example.entity.Labels;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Mapper
public interface LabelsMapper extends BaseMapper<Labels> {
    /**
     * 增
     * @return
     */
    void addLabel(@Param("label") Labels label);

    /**
     * 查全部分类
     * @return
     */
    List<Labels> getLabels();

    /**
     * 改
     * @param id
     * @param name
     * @return
     */
    void updateLabel(@Param("id")Integer id,@Param("name")String name,@Param("description")String description);

    /**
     * 删
     * @param id
     */
    void deleteLabel(Integer id);

    Labels selectForLabel(@Param("id")Integer id);

    /**
     * 查询一个分类下的
     * @param id
     * @return
     */
    Labels selectOne(@Param("id")Integer id);

    /**
     * 查询全部分类下的
     * @return
     */
    List<Labels> selectAll();
    /**
     * 查询前10个分类
     * @return
     */
    List<Labels> getTenLabels();
}
