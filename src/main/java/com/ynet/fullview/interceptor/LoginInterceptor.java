package com.ynet.fullview.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.util.JsonResult;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(null==user) {
            JsonResult jsonResult = new JsonResult(401,new ActionException("登录超时，请重新登录"));
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(jsonResult));
            return false;
        }
        return true;
    }
}
