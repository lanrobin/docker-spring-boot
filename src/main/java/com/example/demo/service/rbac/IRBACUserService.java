package com.example.demo.service.rbac;

import com.example.demo.pojo.rbac.RBACPermission;
import com.example.demo.pojo.rbac.RBACUser;

import java.util.List;

public interface IRBACUserService {
    RBACUser getUserByName(String name);
    List<RBACPermission> getPermissionsByUserId(long userId);
}
