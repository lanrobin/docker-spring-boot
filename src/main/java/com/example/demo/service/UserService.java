package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.service.rbac.IRBACUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IRBACUserService rbacUserService;
    @Override
    public User getUserByName(String name) {
        var rabcUser = rbacUserService.getUserByName(name);
        var user = new User();
        user.setRabc(rabcUser);
        return user;
    }

}
