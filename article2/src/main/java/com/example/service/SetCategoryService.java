package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.SetCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
public interface SetCategoryService extends IService<SetCategory> {
    ResultVo setCategoryForArticle(Integer articleId,String categoryName);
}
