package group1.unnamed.service;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo addUser(SignUpDTO signUpDTO);

}
