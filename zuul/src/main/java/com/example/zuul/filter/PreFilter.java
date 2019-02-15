package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringCloud
 * Author: jianghaotian
 * Create Time:2019/2/14 13:44
 */

/**
 * Zuul过滤器
 */

@Component
public class PreFilter extends ZuulFilter {
    /**
     * 过滤器类型
     * pre:请求被路由之前调用
     * routing:在路由请求时被调用
     * post:在routing的error过滤器之后被调用
     * error:处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * 数值越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否被执行
     * 返回一个boolean值来判断该过滤器是否要执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 实现自定义的过滤逻辑，来确定是否拦截当前请求，不对其进行后续的路由，
     * 或是在请求路由返回结果之后，对处理结果做一些加工等。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //1.过滤器基本功能
//        Object accessToken = request.getParameter("token");
//        if(accessToken == null) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("token is empty");
//            }catch (Exception e){
//
//            }
//            return null;
//        }
        //2.非error过滤器处理异常
//        try {
//            throwException();
//        } catch (Exception e) {
//            System.out.println("捕捉异常:" + e);
//            throw new ZuulRuntimeException(new ZuulException(e, HttpStatus.BAD_REQUEST.value(), e.getMessage()));
//        }
        //3.配合error过滤器处理异常
//        throwException();
        return null;
    }

    private void throwException() {
        System.out.println("开始抛出异常");
        throw new RuntimeException("hahaha");
    }
}
