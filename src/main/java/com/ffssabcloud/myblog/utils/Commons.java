package com.ffssabcloud.myblog.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

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
//        return 2 + suffix;
    }
}
