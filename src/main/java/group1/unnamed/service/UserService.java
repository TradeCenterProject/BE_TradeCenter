package group1.unnamed.service;

import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    ResponseEntity signupUser(SignUpDTO signUpDTO);

//    ResponseEntity loginUser(LoginDTO loginDTO, HttpServletRequest request);
    String loginUser(LoginDTO loginDTO, HttpServletRequest request);

    Object logoutUser(HttpServletRequest request);

}
