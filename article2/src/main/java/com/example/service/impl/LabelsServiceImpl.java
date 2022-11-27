package com.example.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.common.vo.ResultStatus;
import com.example.common.vo.ResultVo;
import com.example.entity.Labels;
import com.example.mapper.LabelsMapper;
import com.example.service.LabelsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
@Service
public class LabelsServiceImpl extends ServiceImpl<LabelsMapper, Labels> implements LabelsService {
    @Autowired
    private LabelsMapper labelsMapper;


    @Override
    public ResultVo addLabel(Labels label) {
        labelsMapper.addLabel(label);
        return new ResultVo(ResultStatus.OK,"添加成功",null);
    }

    @Override
    public ResultVo getLabel() {
        List<Labels> labels = labelsMapper.getLabels();
        return new ResultVo(ResultStatus.OK,"查询成功",labels);
    }@Override
    public ResultVo getTenLabels() {
        List<Labels> labels = labelsMapper.getTenLabels();
        return new ResultVo(ResultStatus.OK,"查询成功",labels);
    }

    @Override
    public ResultVo selectForLabel(Integer id) {
        Labels labels = labelsMapper.selectForLabel(id);
        return new ResultVo(ResultStatus.OK,"查询成功",labels);
    }

    @Override
    public ResultVo updateLabel(Integer id, String name,String description) {
        labelsMapper.updateLabel(id,name,description);
        return new ResultVo(ResultStatus.OK,"修改成功","");
    }

    @Override
    public ResultVo deleteLabel(Integer id) {
        labelsMapper.deleteLabel(id);
        return new ResultVo(ResultStatus.OK,"删除成功","");
    }
}
