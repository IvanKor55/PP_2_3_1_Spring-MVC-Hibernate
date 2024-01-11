package web.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.hibernate.dao.UserDao;
import web.hibernate.model.User;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user) { userDao.addUser(user); }
    @Transactional
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    @Transactional
    @Override
    public List<User> getListUsers() { return userDao.getListUsers(); }
    @Transactional
    @Override
    public User getUser (Integer id) {
        return userDao.getUser((long) id);
    }
}