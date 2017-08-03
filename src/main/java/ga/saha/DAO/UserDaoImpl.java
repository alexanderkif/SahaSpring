package ga.saha.DAO;

import ga.saha.entitys.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(User user) {
        return getSession().save(user);
    }

    @Override
    public User findById(final Serializable id) {
        return getSession().get(User.class, id);
    }
}
