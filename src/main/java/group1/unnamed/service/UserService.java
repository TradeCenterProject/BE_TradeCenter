package group1.unnamed.service;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    ResponseEntity signupValidation(SignUpDTO signUpDTO);

    UserInfo signupUser(SignUpDTO signUpDTO);

    UserInfo loginUser(LoginDTO loginDTO, HttpServletRequest request);

    Object logoutUser(HttpServletRequest request);

}
