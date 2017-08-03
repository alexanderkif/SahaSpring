package ga.saha.services;

import ga.saha.entitys.User;

public interface UserService {

    User getUser(Integer id);

    void addNewUser(User user);
}
