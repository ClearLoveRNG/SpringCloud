package com.example.feign.Impl;

import com.example.feign.api.IFeign;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/13 17:02
 */
@Component
public class FeignErrorImpl implements IFeign{
    @Override
    public String consumerHello() {
        return "sorry,sorry,error";
    }
}
