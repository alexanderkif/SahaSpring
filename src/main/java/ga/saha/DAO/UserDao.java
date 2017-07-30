package ga.saha.DAO;

import ga.saha.entitys.UserEntity;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by ya on 30.07.2017.
 */
public interface UserDao {

    Session getSession();

    Serializable save(UserEntity userEntity);

    UserEntity findById(final Serializable id);

}
