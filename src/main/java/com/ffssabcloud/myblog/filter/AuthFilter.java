package com.ffssabcloud.myblog.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.filter.authenticator.Authenticator;
import com.ffssabcloud.myblog.filter.authenticator.LocalAuthenticator;
import com.ffssabcloud.myblog.modal.UserContext;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.Commons;

@Order(1)
@WebFilter(filterName = "authFilter")
@Configuration
public class AuthFilter implements Filter{
     
    @Autowired
    LocalAuthenticator localAuthenticator;
    
    private List<Authenticator> authenticators;
    
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        User user = tryGetAuthenticatedUser(request, response);
        
        try(UserContext context = new UserContext(user)) {
            chain.doFilter(request, response);
        } catch (Exception e) {}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    public User tryGetAuthenticatedUser(ServletRequest request, ServletResponse response) {
        User user = null;
        
        if(authenticators == null) {
            authenticators = initAuthenticators();
        }
        
        for(Authenticator auth : authenticators) {
            user = auth.authenticate((HttpServletRequest) request);          
            if(user != null) {
                break;
            }
        }
        return user;
    }
    
    public ArrayList<Authenticator> initAuthenticators() {
        ArrayList<Authenticator> authenticators = new ArrayList<Authenticator>();
        authenticators.add(localAuthenticator);
        
        return authenticators;
    }

}
