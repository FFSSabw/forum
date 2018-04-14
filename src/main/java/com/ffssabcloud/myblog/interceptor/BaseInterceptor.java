package com.ffssabcloud.myblog.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.Commons;

@Component
public class BaseInterceptor implements HandlerInterceptor{
    
    @Resource
    Commons commons;
    
    @Autowired
    SiteService siteService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception { 
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
        
        if(userInfo != null && "GET".equals(request.getMethod())) {
            String uuid = "abc";
            session.setAttribute("_csrf_token", uuid);
            request.setAttribute("_csrf_token", uuid);
        }
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
        
        request.setAttribute("commons", commons);
        request.setAttribute("categories", siteService.getMetas(Constrants.Types.CATEGORIES));
        request.setAttribute("userInfo", userInfo);
    }
    
    
}
