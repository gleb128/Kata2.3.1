package web.dao;

import web.model.User;

import java.util.List;

public interface Userdao {
    void createUsersTable();

    void saveUser(User user);

    void deleteUser(Long id);

    User findUser(Long id);

    List<User> findAllUsers();
}
