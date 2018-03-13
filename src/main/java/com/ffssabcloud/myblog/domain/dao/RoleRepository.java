package com.ffssabcloud.myblog.domain.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ffssabcloud.myblog.domain.Role;

@Component
public interface RoleRepository {
    public Role[] findRolesById(Integer id);
}
