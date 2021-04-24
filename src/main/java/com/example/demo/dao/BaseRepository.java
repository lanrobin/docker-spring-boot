package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseRepository {

    @Autowired
    /***
     * 这个jdbc是给没有参数的SQL用的，因为不存在sql injection 的问题。
     */
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
