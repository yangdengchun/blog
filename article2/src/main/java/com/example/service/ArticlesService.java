package com.example.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultVo;
import com.example.entity.Articles;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

/**
 * <p>
 * 博文表 服务类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
public interface ArticlesService extends IService<Articles> {

    ResultVo getArticles();
    ResultVo getArticlesById(Integer id);
    ResultVo addArticles(Articles articles);
    ResultVo updateArticles(Integer id,Articles articles);
    ResultVo delArticles(Integer id);

    ResultVo selectOne(Integer id);

    ResultVo selectAll();

    /**
     * 分页查询
     * @return
     */
    ResultVo selectPage(Integer pageNum,Integer PageSize);

}
