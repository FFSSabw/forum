package com.ffssabcloud.myblog.service.imple;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffssabcloud.myblog.domain.Option;
import com.ffssabcloud.myblog.domain.OptionExample;
import com.ffssabcloud.myblog.domain.dao.OptionMapper;
import com.ffssabcloud.myblog.exception.PromptException;
import com.ffssabcloud.myblog.service.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService{
    
    @Autowired
    OptionMapper optionDao;
    
    @Override
    public List<Option> getOptions() {
        return optionDao.selectByExample(new OptionExample());
    }

    @Override
    @Transactional
    public void saveOptions(Map<String, String> options) {
        
        options.forEach((key, value) -> {
            if(StringUtils.isBlank(key)) {
                throw new PromptException("key值不能为空!");
            }
            Option option = new Option();
            option.setName(key);
            option.setValue(value);
            optionDao.updateByPrimaryKeySelective(option);
        });
        
    }


}
