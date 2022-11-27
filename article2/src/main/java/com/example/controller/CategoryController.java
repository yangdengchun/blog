package com.example.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Category;
import com.example.service.CategoryService;
import com.example.service.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/category")
@Api(tags = "分类管理接口",value = "分类管理")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @ApiOperation("新增分类接口")
    @PostMapping("/savecategory")
    @ResponseBody
    public ResultVo saveCategory(@RequestBody Category category){
        return  categoryService.saveCategory(category);
    }

    @ApiOperation("删除分类接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id", value = "分类id",dataTypeClass = Long.class,required = true),
    })
    @DeleteMapping ("/diletecategory/{id}")
    public ResultVo deleteCategory(@PathVariable("id")Integer id){
        return  categoryService.deleteCategory(id);
    }

    @ApiOperation("更新分类接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "id", value = "分类id",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "String",name = "name", value = "新名称",dataTypeClass = Long.class,required = true),
    })
    @PutMapping("/updatecategory/{id}/{name}/{description}")
    public ResultVo updateCategory(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("description")String description){
        Integer si = Integer.parseInt(id);
        return  categoryService.updateCategory(si,name,description);
    }

    @ApiOperation("查询分类接口")
    @GetMapping("/getcategory")
    public ResultVo getCategory(){
        return  categoryService.getCategory();
    }

    @ApiOperation("查询分类一个接口")
    @GetMapping("/getcategoryone/{id}")
    public ResultVo getCategoryForOne(@PathVariable("id")Integer id){
        return  categoryService.selectForOne(id);
    }

    @ApiOperation("查询分类接口")
    @GetMapping("/getcategoryforarticleall")
    public ResultVo getCategoryForArticleAll(){
        return  categoryService.selectAll();
    }

    @ApiOperation("查询推荐分类接口")
    @GetMapping("/getcategoryforarticleallforfour")
    public ResultVo getFourCategoryForArticle(){
        return  categoryService.selectFour();
    }
    @ApiOperation("根据分类id查询博文口")
    @GetMapping("/getArticleForCategory/{id}")
    public ResultVo getArticleForCategory(@PathVariable("id")Integer id){
        return  categoryService.selectForCategory(id);
    }




}

