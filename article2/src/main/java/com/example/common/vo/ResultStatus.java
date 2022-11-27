package com.example.common.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author ydc
 * @create 2022-08-06 14:05
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultStatus {
    OK(200),
    NO(400);

    private Integer code;


    public Integer getCode() {
        return code;
    }
}
