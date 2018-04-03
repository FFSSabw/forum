package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Categories;
import com.ffssabcloud.myblog.domain.Tag;

public interface MetaService {
    public List<Categories> getCategories();
    public List<Tag> getTags();
}
