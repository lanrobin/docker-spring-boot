package com.example.demo.dao.rabc;

import com.example.demo.dao.BaseRepository;
import com.example.demo.pojo.rbac.RBACPermission;
import com.example.demo.pojo.rbac.RBACUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class RBACRepository extends BaseRepository implements IRBACRepository {

    private static String INSERT_SQL = "INSERT INTO rbac_user(username, password, locked) VALUES(:username, :password, :locked)";

    @Override
    public int insertUser(RBACUser user) {

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(INSERT_SQL, parameterSource);
    }

    @Override
    public int insertUsers(Collection<RBACUser> users) {
        var params = SqlParameterSourceUtils.createBatch(users);
        var result = namedParameterJdbcTemplate.batchUpdate(INSERT_SQL, params);
        return result.length;
    }

    @Override
    public RBACUser getUserByName(String name) {

        var sql = "SELECT id, username, password, locked FROM rbac_user WHERE username = :username";
        var param = new MapSqlParameterSource().addValue("username", name);
        return namedParameterJdbcTemplate.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(RBACUser.class));
    }

    @Override
    public List<RBACPermission> getUserPermissions(long userId) {

        var sql = "SELECT id, permission_name, permission_code FROM user_permission_view WHERE user_id =:user_id";
        var param = new MapSqlParameterSource().addValue("user_id", userId);
        return namedParameterJdbcTemplate.query(sql, param, BeanPropertyRowMapper.newInstance(RBACPermission.class));
    }
}
