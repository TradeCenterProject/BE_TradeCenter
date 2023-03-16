package group1.unnamed.controller;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.service.TaskService;
import group1.unnamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public UserInfo login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {

        return userService.loginUser(loginDTO, request);
    }
    @PostMapping(value = "/validation")
    public ResponseEntity signupValidation(@RequestBody SignUpDTO signUpDTO) {

        return userService.signupValidation(signUpDTO);
    }

    @PostMapping(value = "/signUp")
    public UserInfo signup(@RequestBody SignUpDTO signUpDTO) {

        return userService.signupUser(signUpDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
