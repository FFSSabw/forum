package com.ffssabcloud.myblog.utils;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.constant.Constrants;

/**
 * 公共函数
 * @author fssaw
 *
 */
@Component
public class Commons {
    
    public String random(int max, String suffix) {
        Random random = new Random();
        return (random.nextInt(max-1+1) + 1) + suffix;
    }
  
}
