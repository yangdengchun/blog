package com.example.controller;


import com.example.common.vo.ResultVo;
import com.example.entity.Category;
import com.example.entity.Labels;
import com.example.service.CategoryService;
import com.example.service.LabelsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@RestController
@RequestMapping("/label")
@Api(tags = "标签管理接口",value = "标签管理")
public class LabelsController {
    @Resource
    private LabelsService labelsService;

    @ApiOperation("新增标签接口")
    @PostMapping("/addlabel")
    @ResponseBody
    public ResultVo addLabel(@RequestBody Labels label){
        return  labelsService.addLabel(label);
    }

    @ApiOperation("删除标签接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Integer",name = "id", value = "标签id",dataTypeClass = Long.class,required = true),
    })
    @DeleteMapping ("/diletelabel/{id}")
    public ResultVo deleteLabel(@PathVariable("id")Integer id){
        return  labelsService.deleteLabel(id);
    }

    @ApiOperation("更新标签接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "id", value = "标签id",dataTypeClass = Long.class,required = true),
            @ApiImplicitParam(dataType = "String",name = "name", value = "新名称",dataTypeClass = Long.class,required = true),
    })
    @PutMapping("/updatelabel/{id}/{name}/{description}")
    public ResultVo updateLabel(@PathVariable("id")String id,@PathVariable("name")String name,@PathVariable("description")String description){
        Integer si = Integer.parseInt(id);
        return  labelsService.updateLabel(si,name,description);
    }

    @ApiOperation("查询标签接口")
    @GetMapping("/getlabel")
    public ResultVo getLabel(){
        return  labelsService.getLabel();
    }

    @ApiOperation("推荐标签接口")
    @GetMapping("/gettenlabel")
    public ResultVo getTenLabels(){
        return  labelsService.getTenLabels();
    }

    @ApiOperation("根据标签id查询博文接口")
    @GetMapping("/getForLabel/{id}")
    public ResultVo getForLabels(@PathVariable("id")Integer id){
        return  labelsService.selectForLabel(id);
    }

}

