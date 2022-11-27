package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.entity.Articles;
import com.example.entity.Category;
import com.example.service.ArticlesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 博文表 前端控制器
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/articles")
@Api(tags = "博文管理接口",value = "博文管理")

public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @ApiOperation("博文查询接口")
    @GetMapping("/getarticle")
    public ResultVo getArticle(){
        ResultVo resultVo = articlesService.getArticles();
        return resultVo;
    }
    @ApiOperation("根据博文id查询接口")
    @GetMapping("/getarticlebyid/{id}")
    public ResultVo getArticleById(@PathVariable("id")Integer id){
        ResultVo resultVo = articlesService.getArticlesById(id);
        return resultVo;
    }
    @ApiOperation("博文分类查询接口")
    @GetMapping("/getcategoryarticle/{id}")
    public ResultVo getCategoryForArticle(@PathVariable("id") Integer id){
        ResultVo resultVo = articlesService.selectOne(id);
        return resultVo;
    }
    @ApiOperation("博文分类查询全部接口")
    @GetMapping("/getcategoryarticle")
    public ResultVo getCategoryForArticleAll(){
        ResultVo resultVo = articlesService.selectAll();
        return resultVo;
    }

    @ApiOperation("新增博文接口")
    @PostMapping("/addarticle")
    @ResponseBody
    public ResultVo addArticle(@RequestBody Articles articles){
        return  articlesService.addArticles(articles);
    }

    @ApiOperation("删除博文接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id", value = "博文id",dataTypeClass = Long.class,required = true),
    })
    @DeleteMapping ("/diletearticle/{id}")
    public ResultVo deleteArticle(@PathVariable("id")Integer id){
        return  articlesService.delArticles(id);
    }

    @ApiOperation("更新分类接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "id", value = "博文id",dataTypeClass = Long.class,required = true),
    })
    @PostMapping("/updatearticle/{id}")
    @ResponseBody
    public ResultVo updateArticle(@PathVariable("id")String id,@RequestBody Articles article){
        Integer si = Integer.parseInt(id);
        return  articlesService.updateArticles(si,article);
    }

    @ApiOperation("分页查询接口")
    @GetMapping("/getArticlePage/{pageNum}/{pageSize}")
    public ResultVo getArticlePage(@PathVariable("pageNum")Integer pageNum,@PathVariable("pageSize")Integer pageSize){

        ResultVo resultVo = articlesService.selectPage(pageNum,pageSize);
        return resultVo;
    }

}

