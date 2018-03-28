package com.ffssabcloud.myblog.web;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ffssabcloud.myblog.constant.Constrants;

@Controller
public class IndexController extends BaseController{
    
    @GetMapping(value = "/")
    public String index(HttpServletRequest request,
                        @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return this.index(request, 1, limit);
    }
    
    @GetMapping(value = "/page/{page}")
    public String index(HttpServletRequest request,
                        @PathVariable int page,
                        @RequestParam(value = "limit", defaultValue = "12") int limit) {
        page = page < 0 || page > Constrants.Web.MAX_PAGE ? 1 : page;
        
        return "index";                    
    }
}
