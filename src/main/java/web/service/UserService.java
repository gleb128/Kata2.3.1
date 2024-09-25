package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteUser(Long id);

    User findUser(Long id);

    List<User> findAllUsers();

    void updateUser(User user);
}