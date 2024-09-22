package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
     entityManager.getTransaction().begin();
     entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS users (").executeUpdate();
     entityManager.getTransaction().commit();
    }
    @Transactional
    @Override
    public void saveUser(String name, String lastName, Byte age) {
        entityManager.getTransaction().begin();
        entityManager.persist(new User(name, lastName, age));
        entityManager.getTransaction().commit();
    }
    @Transactional
    @Override
    public void updateUser(String name, String lastName, Byte age) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, name);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
        }
        entityManager.getTransaction().commit();
    }
    @Transactional
    @Override
    public void deleteUser(Byte id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }
    @Transactional
    @Override
    public User findUser(Byte id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }


}

