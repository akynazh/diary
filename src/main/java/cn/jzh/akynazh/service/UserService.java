package cn.jzh.akynazh.service;

import cn.jzh.akynazh.bean.User;
import cn.jzh.akynazh.dao.UserDao;
import cn.jzh.akynazh.dao.impl.UserDaoImpl;

public interface UserService {
    public void register(User user);
    public boolean existsUsername(String username);
    public User login(User user);
}
