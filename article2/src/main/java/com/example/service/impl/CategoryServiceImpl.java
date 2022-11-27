package com.example.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Category;
import com.example.mapper.CategoryMapper;
import com.example.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResultVo saveCategory(Category category) {
         categoryMapper.saveCategory(category);
        return new ResultVo(ResultStatus.OK,"添加成功","");
    }

    @Override
    public ResultVo getCategory() {
        List<Category> category = categoryMapper.getCategory();
        return new ResultVo(ResultStatus.OK,"查询成功",category);
    }


    @Override
    public ResultVo updateCategory(Integer id, String name,String description) {
        categoryMapper.updateCategory(id, name,description);
        return new ResultVo(ResultStatus.OK,"修改成功","");
    }

    @Override
    public ResultVo deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
        return new ResultVo(ResultStatus.OK,"删除成功","");
    }


    @Override
    public ResultVo selectForOne(Integer id) {
        Category category = categoryMapper.selectForOne(id);
        return new ResultVo(ResultStatus.OK,"查询成功",category);
    }

    @Override
    public ResultVo selectAll() {
        List<Category> categories = categoryMapper.selectAll();
        return new ResultVo(ResultStatus.OK,"查询成功",categories);
    }
    @Override
    public ResultVo selectFour() {
        List<Category> categories = categoryMapper.selectFour();
        return new ResultVo(ResultStatus.OK,"查询成功",categories);
    }

    @Override
    public ResultVo selectForCategory(Integer id) {
        Category categories = categoryMapper.selectForCategory(id);
        return new ResultVo(ResultStatus.OK,"查询成功",categories);
    }
}
