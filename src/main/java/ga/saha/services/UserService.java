package ga.saha.services;

import ga.saha.entitys.UserEntity;

public interface UserService {

    UserEntity getUser(Long id);

    void addNewUser(UserEntity userEntity);
}
