package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.rbac.RBACUser;
import com.example.demo.service.rbac.IRBACUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private IRBACUserService rbacUserService;
    @Override
    public User getUserByName(String name) {
        var rabcUser = loadUserByUsername(name);
        var user = new User();
        user.setRabc((RBACUser) rabcUser);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        var rabcUser = rbacUserService.getUserByName(name);

        if(rabcUser == null)
        {
            throw new UsernameNotFoundException(name);
        }

        var permissions = rbacUserService.getPermissionsByUserId(rabcUser.getId());

        if(!CollectionUtils.isEmpty(permissions)) {
            Set<SimpleGrantedAuthority> sga = new HashSet<>();
            permissions.forEach(p->{
                sga.add(new SimpleGrantedAuthority(p.getPermissionCode()));
            });
            rabcUser.setAuthorities(sga);
        }
        return rabcUser;
    }
}
