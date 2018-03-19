package com.ffssabcloud.myblog;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ffssabcloud.myblog.domain.LocalAuth;
import com.ffssabcloud.myblog.domain.Role;
import com.ffssabcloud.myblog.domain.User;
import com.ffssabcloud.myblog.domain.dao.UserRepository;
import com.ffssabcloud.myblog.service.UserService;
import com.ffssabcloud.myblog.utils.RedisUtils;
import com.ffssabcloud.myblog.utils.WebUtils;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {
    
    @Autowired
    private CacheManager cacheManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WebUtils webUtils;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RedisUtils redisUtils;
    
    @Test
    public void testDb() throws IllegalArgumentException, IllegalAccessException {
//        String hashed = webUtils.hashWithSalt("123456");
//        System.out.println(hashed);
//        System.out.println(webUtils.hashVertify(hashed, "123456"));
//        User user1 = userService.getUserByUsername("abc");
//        System.out.println("first password:" + ((LocalAuth)user1.getAuth()).getPassword());
//        User user2 = userService.getUserByUsername("abc");
//        System.out.println("second password:" + ((LocalAuth)user2.getAuth()).getPassword());
//        System.out.println(redisUtils.exists("\\xac\\xed\\x00\\x05t\\x00\\aredis__"));
//        redisUtils.set("afsddslvn lxvkx", "fsdjklbfdsfnlksdaf");
//        redisUtils.remove("a");
         
        
    }
}
