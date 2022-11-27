package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
public interface CategoryService extends IService<Category> {
    /**
     * 增
     * @param category
     * @return
     */
    ResultVo saveCategory(Category category);

    /**
     * 查
     * @return
     */
    ResultVo getCategory();

    /**
     * 改
     * @param id
     * @param name
     * @return
     */
    ResultVo updateCategory(Integer id,String name,String description);

    /**
     * 删
     * @param id
     */
    ResultVo deleteCategory(Integer id);

    ResultVo selectForOne(Integer id);

    ResultVo selectAll();
    ResultVo selectFour();

    ResultVo selectForCategory(Integer id);

}
