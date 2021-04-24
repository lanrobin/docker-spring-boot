package com.example.demo.dao.rabc;

import com.example.demo.pojo.rbac.RBACUser;

import java.util.Collection;

public interface IRBACUserRepository {
    int insertUser(RBACUser user);
    int insertUsers(Collection<RBACUser> users);

    RBACUser getUserByName(String name);
}
