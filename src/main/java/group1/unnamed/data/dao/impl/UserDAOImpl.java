package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.dao.UserDAO;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.data.repository.TaskRepository;
import group1.unnamed.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAOImpl implements UserDAO {

    UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUser(int userId) {
        return userRepository.getReferenceById(userId);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Boolean isUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
