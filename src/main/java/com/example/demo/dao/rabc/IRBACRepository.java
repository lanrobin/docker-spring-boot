package com.example.demo.dao.rabc;

import com.example.demo.pojo.rbac.RBACPermission;
import com.example.demo.pojo.rbac.RBACUser;

import java.util.Collection;
import java.util.List;

public interface IRBACRepository {
    int insertUser(RBACUser user);
    int insertUsers(Collection<RBACUser> users);

    RBACUser getUserByName(String name);

    List<RBACPermission> getUserPermissions(long userId);
}
