package com.ffssabcloud.myblog.service;

import java.util.List;
import java.util.Map;

import com.ffssabcloud.myblog.domain.Option;

public interface IOptionService {
    public List<Option> getOptions();
    public void saveOptions(Map<String, String> options);
}
