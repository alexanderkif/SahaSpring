package ga.saha.DAO;

import ga.saha.entitys.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(User user) {
        return getSession().save(user);
    }

    @Override
    public User findByEmail(String email) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> userRoot = q.from(User.class);

        q.where(cb.equal(userRoot.get("email"), email));
        return getSession().createQuery(q).getSingleResult();
    }

    @Override
    public User findById(final Serializable id) {
        return getSession().get(User.class, id);
    }
}
