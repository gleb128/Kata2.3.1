package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PostPersist;
import java.util.List;


@Repository
public class UserDaoHibernate implements Userdao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createUsersTable() {
     entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS users (").executeUpdate();
    }

    @Transactional
    @Override
    public void saveUser(String name, String lastName, Byte age) {
        entityManager.persist(new User(name, lastName, age));
    }

    @Transactional
    @Override
    public void updateUser(String name, String lastName, Byte age) {
        User user = entityManager.find(User.class, name);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Byte id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional
    @Override
    public User findUser(Byte id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public List<User> findAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }


}

