package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public void createUsersTable();
    public void saveUser(String name, String lastName, Byte age);
    public void updateUser(String name, String lastName, Byte age);
    public  void deleteUser(Byte id);
    public User findUser(Byte id);
    public List<User> findAllUsers();
}