package com.example.interceptor;

import com.example.config.DynamicDataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String databaseName = request.getParameter("databaseName");
        if (databaseName != null && !databaseName.isEmpty()) {
            DynamicDataSourceContextHolder.setDataSourceKey(databaseName);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }
}