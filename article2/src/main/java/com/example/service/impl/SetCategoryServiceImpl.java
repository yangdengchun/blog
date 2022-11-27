package com.example.service.impl;

import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.SetCategory;
import com.example.mapper.SetCategoryMapper;
import com.example.service.SetCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@Service
public class SetCategoryServiceImpl extends ServiceImpl<SetCategoryMapper, SetCategory> implements SetCategoryService {

    @Autowired
    private SetCategoryMapper setCategoryMapper;
    @Override
    public ResultVo setCategoryForArticle(Integer articleId, String categoryName) {
        setCategoryMapper.setCategoryForArticle(articleId,categoryName);
        return new ResultVo(ResultStatus.OK,"查询成功",null);
    }
}
