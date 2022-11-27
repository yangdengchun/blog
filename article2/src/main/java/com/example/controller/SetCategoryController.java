package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.service.SetCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ydc
 * @since 2022-09-21
 */
@RestController
@RequestMapping("/setCategory")
@Api(tags = "设置分类管理接口",value = "设置分类管理")

public class SetCategoryController {

    @Autowired
    private SetCategoryService setCategoryService;


    @ApiOperation("分类设置接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "articleId", value = "文章id",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "string",name = "categoryName", value = "分类名称",dataTypeClass = Long.class,required = true)
    })
    @PostMapping("/setCategory")
    public ResultVo setCategory(@RequestParam(value = "articleId")Integer articleId,
                           @RequestParam(value = "categoryName")String categoryName){
        ResultVo resultVo = setCategoryService.setCategoryForArticle(articleId, categoryName);
        return resultVo;
    }
}

