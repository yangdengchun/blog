package com.example.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Articles;
import com.example.mapper.ArticlesMapper;
import com.example.service.ArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 博文表 服务实现类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements ArticlesService {

    @Autowired ArticlesMapper articlesMapper;

    @Override
    public ResultVo getArticles() {
        List<Articles> articles = articlesMapper.getArticles();
        return new ResultVo(ResultStatus.OK,"查询成功",articles);
    }

    @Override
    public ResultVo getArticlesById(Integer id) {
        Articles article = articlesMapper.getArticlesById(id);
        return new ResultVo(ResultStatus.OK,"查询成功",article);
    }

    @Override
    public ResultVo addArticles(Articles articles) {
        articlesMapper.addArticles(articles);
        return new ResultVo(ResultStatus.OK,"增加成功","");
    }

    @Override
    public ResultVo updateArticles(Integer id, Articles articles) {
        articlesMapper.updateArticles(id,articles);
        return new ResultVo(ResultStatus.OK,"更新成功","");
    }

    @Override
    public ResultVo delArticles(Integer id) {
        articlesMapper.delArticles(id);
        return new ResultVo(ResultStatus.OK,"删除成功","");
    }

    @Override
    public ResultVo selectOne(Integer id) {
        Articles article = articlesMapper.selectOne(id);
        return new ResultVo(ResultStatus.OK,"查询成功",article);
    }

    @Override
    public ResultVo selectAll() {
        List<Articles> articles = articlesMapper.selectAll();
        return new ResultVo(ResultStatus.OK,"查询成功",articles);
    }

    @Override
    public ResultVo selectPage(Integer pageNum,Integer PageSize) {
        List<Articles> articles = articlesMapper.selectPage(pageNum, PageSize);
        return new ResultVo(ResultStatus.OK,"查询成功",articles);
    }
}
