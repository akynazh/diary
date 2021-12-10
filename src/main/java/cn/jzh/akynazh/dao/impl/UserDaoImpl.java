package cn.jzh.akynazh.dao.impl;

import cn.jzh.akynazh.bean.User;
import cn.jzh.akynazh.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    BaseDao baseDao = new BaseDao();
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, description from td_user where username = ?";
        return baseDao.queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, description from td_user where username = ? and password = ?";
        return baseDao.queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into td_user(username, password, description) values(?, ?, ?)";
        return baseDao.update(sql, user.getUsername(), user.getPassword(), user.getDescription());
    }
}