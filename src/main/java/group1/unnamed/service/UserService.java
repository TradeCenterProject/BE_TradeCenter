package group1.unnamed.service;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    ResponseEntity signupUser(SignUpDTO signUpDTO);

//    ResponseEntity loginUser(LoginDTO loginDTO, HttpServletRequest request);
    String loginUser(LoginDTO loginDTO, HttpServletRequest request);

    Object logoutUser(HttpServletRequest request);

}
