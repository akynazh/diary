package cn.jzh.akynazh.service.impl;

import cn.jzh.akynazh.bean.User;
import cn.jzh.akynazh.dao.UserDao;
import cn.jzh.akynazh.dao.impl.UserDaoImpl;
import cn.jzh.akynazh.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
