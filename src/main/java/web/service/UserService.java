package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
     void createUsersTable();
     void saveUser(String name, String lastName, Byte age);
     void updateUser(String name, String lastName, Byte age);
      void deleteUser(Long id);
     User findUser(Long id);
     List<User> findAllUsers();
}