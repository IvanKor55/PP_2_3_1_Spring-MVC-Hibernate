package web.hibernate.service;

import web.hibernate.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    List<User> getListUsers();
    User getUser (Integer id);
}
