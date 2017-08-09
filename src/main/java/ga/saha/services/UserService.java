package ga.saha.services;

import ga.saha.entitys.User;

public interface UserService {

    User getUserByEmail(String email);

    void addNewUser(User user);
}
