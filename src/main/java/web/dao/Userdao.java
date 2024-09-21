package web.dao;

import web.model.User;

public interface Userdao {
    public void createUsersTable();
    public void saveUser(String name, String lastName, Byte age);
    public void updateUser(String name, String lastName, Byte age);
    public  void deleteUser(Byte id);
    public User findUser(Byte id);
}
