package com.ffssabcloud.forum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ffssabcloud.forum.domain.Role;
import com.ffssabcloud.forum.domain.User;
import com.ffssabcloud.forum.domain.DB1.RoleRepository;
import com.ffssabcloud.forum.domain.DB1.UserRepository;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {
    
    @Autowired
    public UserRepository userRepository;
    
    @Autowired
    public RoleRepository roleRepository;
    @Test
    public void testDb() {
//        userRepository.addAUser(new User(0, "username_A", "password_A", "123456@qq.com"));
//        userRepository.addAUser(new User(1, "username_B", "password_B", "123456@hotmail.com"));
//        userRepository.addAUser(new User(2, "username_C", "password_C", "123456@163.com"));
//        userRepository.addAUser(new User(3, "username_D", "password_D", "123456@128.com"));
//        userRepository.addAUser(new User(4, "username_E", "password_E", "123456@gmail.com"));
        
//        assertEquals(new Integer(5), userRepository.getCountOfUser());
//        
//        User user = userRepository.findByUsername("username_A");
//        
//        assertEquals("username_A", user.getUsername());
//        assertEquals("password_A", user.getPassword());
//        
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
        Role[] roles = roleRepository.findRolesById(100000);
        
        for(Role role : roles) {
            System.out.println(role.getName());
        }
        
    }
}
