package com.ffssabcloud.myblog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.domain.Option;
import com.ffssabcloud.myblog.service.IOptionService;
import com.ffssabcloud.myblog.utils.Commons;

@Component
public class PreProcessRunner implements ApplicationRunner{
    
    @Autowired
    IOptionService optionService;
    
    @Autowired
    Commons commons;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Option> options = optionService.getOptions();
        for(Option option : options) {
            commons.options.put(option.getName(), option.getValue());
        }
    }
}
