package group1.unnamed.data.dao;

import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    UserEntity getUser(int userId);
    UserEntity addUser(UserEntity userEntity);
    Boolean isUserByEmail(String email);
}
