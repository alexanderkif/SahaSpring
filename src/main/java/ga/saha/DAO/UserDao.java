package ga.saha.DAO;

import ga.saha.entitys.User;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by ya on 30.07.2017.
 */
public interface UserDao {

    Session getSession();

    Serializable save(User user);

    User findById(final Serializable id);

}
