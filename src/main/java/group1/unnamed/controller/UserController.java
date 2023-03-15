package group1.unnamed.controller;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.service.TaskService;
import group1.unnamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

//    @GetMapping(value = "")
//    public Object signIn() {
//
//        return taskService.getTaskList(1);
//    }
    @PostMapping(value = "/login")
    public UserInfo login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {


        return userService.loginUser(loginDTO, request);
    }
    @PostMapping(value = "/signUp")
    public UserInfo signUp(@RequestBody SignUpDTO signUpDTO) {


        return userService.addUser(signUpDTO);
    }
}
