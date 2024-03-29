package group1.unnamed.handler;

import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.UserEntity;

import java.util.List;

public interface UserHandler {

    UserEntity getUserEntity(int userId);
    UserEntity getUserEntityByEmail(String email);
    UserEntity addUserEntity(UserEntity userEntity);
    Boolean isUserEntityByEmail(String email);
}
