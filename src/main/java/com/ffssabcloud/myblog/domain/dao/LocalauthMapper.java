package com.ffssabcloud.myblog.domain.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.constant.Constrants;
import com.ffssabcloud.myblog.domain.auth.Localauth;
import com.ffssabcloud.myblog.domain.auth.LocalauthExample;

@Component
public interface LocalauthMapper {
    int countByExample(LocalauthExample example);

    int deleteByExample(LocalauthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Localauth record);

    int insertSelective(Localauth record);
    
    List<Localauth> selectByExample(LocalauthExample example);

    Localauth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Localauth record, @Param("example") LocalauthExample example);

    int updateByExample(@Param("record") Localauth record, @Param("example") LocalauthExample example);

    int updateByPrimaryKeySelective(Localauth record);

    int updateByPrimaryKey(Localauth record);
}