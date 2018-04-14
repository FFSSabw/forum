package com.ffssabcloud.myblog.domain.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ffssabcloud.myblog.domain.auth.LocalAuth;
import com.ffssabcloud.myblog.domain.auth.LocalAuthExample;

public interface LocalAuthMapper {
    int countByExample(LocalAuthExample example);

    int deleteByExample(LocalAuthExample example);

    int deleteByPrimaryKey(String username);

    int insert(LocalAuth record);

    int insertSelective(LocalAuth record);

    List<LocalAuth> selectByExample(LocalAuthExample example);

    LocalAuth selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") LocalAuth record, @Param("example") LocalAuthExample example);

    int updateByExample(@Param("record") LocalAuth record, @Param("example") LocalAuthExample example);

    int updateByPrimaryKeySelective(LocalAuth record);

    int updateByPrimaryKey(LocalAuth record);
}