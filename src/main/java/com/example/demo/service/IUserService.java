package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.rbac.RBACPermission;

import java.util.List;

public interface IUserService {
    User getUserByName(String name);
}
