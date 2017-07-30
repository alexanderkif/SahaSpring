package ga.saha.DAO;

import ga.saha.entitys.UserEntity;
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
    public Serializable save(UserEntity userEntity) {
        return getSession().save(userEntity);
    }

    @Override
    public UserEntity findById(final Serializable id) {
        return getSession().get(UserEntity.class, id);
    }
}
