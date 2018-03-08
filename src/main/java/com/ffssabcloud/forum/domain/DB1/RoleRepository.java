package com.ffssabcloud.forum.domain.DB1;

import com.ffssabcloud.forum.domain.Role;

public interface RoleRepository {
    public Role[] findRolesById(Integer id);
}
