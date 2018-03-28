package com.ffssabcloud.myblog.domain.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ffssabcloud.myblog.domain.auth.Role;
import com.ffssabcloud.myblog.domain.auth.RoleExample;

@Component
public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}