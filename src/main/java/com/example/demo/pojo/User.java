package com.example.demo.pojo;

import com.example.demo.pojo.rbac.RBACUser;

public class User {

    private String email;
    private RBACUser rabc;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RBACUser getRabc() {
        return rabc;
    }

    public void setRabc(RBACUser rabc) {
        this.rabc = rabc;
    }
}
