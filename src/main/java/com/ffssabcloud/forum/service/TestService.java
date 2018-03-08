package com.ffssabcloud.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.forum.domain.DB2.PostRepository;

@Service
public class TestService {
    
    @Autowired
    PostRepository postRepository;
    
    @Transactional(value = "DB2TransactionManager")
    public void addAPosts() throws Exception {
        
    }
}
