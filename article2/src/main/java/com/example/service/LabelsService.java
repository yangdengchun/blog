package com.example.service;

import com.example.common.vo.ResultVo;
import com.example.entity.Category;
import com.example.entity.Labels;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author lishihuai
 * @since 2022-09-20
 */
public interface LabelsService extends IService<Labels> {
    /**
     * 增
     * @param label
     * @return
     */
    ResultVo addLabel(Labels label);

    /**
     * 查
     * @return
     */
    ResultVo getLabel();

    /**
     * 根据id查
     * @return
     */
    ResultVo selectForLabel(Integer id);

    /**
     * 查10个
     * @return
     */
    ResultVo getTenLabels();

    /**
     * 改
     * @param id
     * @param name
     * @return
     */
    ResultVo updateLabel(Integer id,String name,String description);

    /**
     * 删
     * @param id
     */
    ResultVo deleteLabel(Integer id);
}
