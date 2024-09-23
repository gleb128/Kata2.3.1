package web.dao;

import web.model.User;

import java.util.List;

public interface Userdao {
    public void createUsersTable();
    public void saveUser(String name, String lastName, Byte age);
    public void updateUser(String name, String lastName, Byte age);
    public void deleteUser(Long id);
    public User findUser(Long id);
    public List<User> findAllUsers();
}
