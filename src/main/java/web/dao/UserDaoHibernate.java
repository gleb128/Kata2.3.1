package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void saveUser(User user) {
        entityManager.persist(user);
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
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional
    @Override
    public User findUser(Long id) {
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

