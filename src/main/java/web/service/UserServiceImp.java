package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoHibernate;
import web.dao.Userdao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private Userdao userdao;

    @Autowired
    public UserServiceImp(Userdao userDao) {
        this.userdao = userDao;
    }

    @Override
    public void createUsersTable() {
    userdao.createUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, Byte age) {
    userdao.saveUser(name, lastName, age);
    }

    @Override
    public void updateUser(String name, String lastName, Byte age) {
    userdao.updateUser(name, lastName, age);
    }

    @Override
    public void deleteUser(Byte id) {
        userdao.deleteUser(id);
    }

    @Override
    public User findUser(Byte id) {
        return userdao.findUser(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userdao.findAllUsers();
    }
}
