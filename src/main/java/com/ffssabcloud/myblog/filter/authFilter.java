package com.ffssabcloud.myblog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.UserInfo;
import com.ffssabcloud.myblog.utils.WebUtils;

@Order(1)
@WebFilter(filterName = "authFilter")
@Configuration
public class authFilter implements Filter{

    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String uri = httpRequest.getRequestURI();
        UserInfo userInfo = (UserInfo) session.getAttribute(Constrants.Web.SESSION_USERINFO_NAME);
        
        if(!WebUtils.permissionCheck(uri, "/admin", Constrants.Roles.ADMIN, userInfo)) {
            return;
        }
        if(!WebUtils.permissionCheck(uri, "/actuator", Constrants.Roles.ADMIN, userInfo)) {
            return;
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }

}
