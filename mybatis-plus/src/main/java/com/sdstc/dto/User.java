package com.sdstc.dto;

import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import lombok.Data;

@Data
public class User {
    DynamicTableNameInnerInterceptor
    private String  name;
    private String  pwd;
}
