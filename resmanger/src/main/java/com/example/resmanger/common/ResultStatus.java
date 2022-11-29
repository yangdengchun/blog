package com.example.resmanger.common;

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
