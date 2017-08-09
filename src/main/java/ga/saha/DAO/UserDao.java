package ga.saha.DAO;

import ga.saha.entitys.User;
import org.hibernate.Session;

import java.io.Serializable;

public interface UserDao {

    Session getSession();

    Serializable save(User user);

    User findByEmail(String email);

    User findById(final Serializable id);

}
