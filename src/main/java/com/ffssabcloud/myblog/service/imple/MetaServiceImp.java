package com.ffssabcloud.myblog.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffssabcloud.myblog.domain.Categories;
import com.ffssabcloud.myblog.domain.CategoriesExample;
import com.ffssabcloud.myblog.domain.Tag;
import com.ffssabcloud.myblog.domain.TagExample;
import com.ffssabcloud.myblog.domain.dao.CategoriesMapper;
import com.ffssabcloud.myblog.domain.dao.TagMapper;
import com.ffssabcloud.myblog.service.MetaService;

@Service
public class MetaServiceImp implements MetaService{
    
    @Autowired
    CategoriesMapper categoriesMapper;
    
    @Autowired
    TagMapper tagMapper;
    
    @Override
    public List<Categories> getCategories() {
        return categoriesMapper.selectByExample(new CategoriesExample());

    }

    @Override
    public List<Tag> getTags() {
        return tagMapper.selectByExample(new TagExample());

    }

}
