package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.dao.UserDAO;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.handler.TaskHandler;
import group1.unnamed.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserHandlerImpl implements UserHandler {

    UserDAO userDAO;

    @Autowired
    public UserHandlerImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserEntity getUserEntity(int userId) {
        return userDAO.getUser(userId);
    }
}