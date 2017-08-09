package ga.saha.services;

import ga.saha.DAO.UserDao;
import ga.saha.entitys.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserService.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByEmail(String email) {
        logger.debug("Getting user with email " + email);
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = false)
    public void addNewUser(User user) {
        Integer id = (Integer) userDao.save(user);
        logger.debug("Id of new user " + id);
    }
}

