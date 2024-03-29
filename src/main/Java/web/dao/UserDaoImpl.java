package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String LIST_USER = "SELECT u FROM User u";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.find(User.class, user.getId()));
    }

    @Override
    public List<User> getListUsers() {
        return entityManager.createQuery(LIST_USER, User.class).getResultList();
    }

    @Override
    public User getUser (Long id) {
        return entityManager.find(User.class, id);
    }
}
