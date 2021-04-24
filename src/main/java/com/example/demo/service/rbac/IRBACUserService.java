package com.example.demo.service.rbac;

import com.example.demo.pojo.rbac.RBACUser;

public interface IRBACUserService {
    RBACUser getUserByName(String name);
}
