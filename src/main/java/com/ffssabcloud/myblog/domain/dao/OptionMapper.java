package com.ffssabcloud.myblog.domain.dao;

import com.ffssabcloud.myblog.domain.Option;
import com.ffssabcloud.myblog.domain.OptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionMapper {
    int countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(String name);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}