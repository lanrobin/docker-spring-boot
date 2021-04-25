package com.example.demo.service.rbac;

import com.example.demo.dao.rabc.IRBACRepository;
import com.example.demo.pojo.rbac.RBACUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RBACUserService implements IRBACUserService{

    @Autowired
    private IRBACRepository rbacUserRepository;

    @Override
    public RBACUser getUserByName(String name) {
        return rbacUserRepository.getUserByName(name);
    }
}
