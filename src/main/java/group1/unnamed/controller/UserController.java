package group1.unnamed.controller;

import group1.unnamed.data.dto.AddTaskStocksDTO;
import group1.unnamed.data.dto.GetTaskDTO;
import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.exception.CustomException;
import group1.unnamed.exception.ExceptionConstants;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.UserHandler;
import group1.unnamed.service.TaskService;
import group1.unnamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class UserController {

    UserService userService;
    UserHandler userHandler;
    CompanyHandler companyHandler;

    @Autowired
    public UserController(UserService userService, UserHandler userHandler, CompanyHandler companyHandler) {
        this.companyHandler = companyHandler;
        this.userHandler = userHandler;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public UserInfo login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {

        return userService.loginUser(loginDTO, request);
    }
    @PostMapping(value = "/validation")
    public ResponseEntity signupValidation(@RequestBody SignUpDTO signUpDTO) throws CustomException {
        String email = signUpDTO.getEmail();

        if (userHandler.isUserEntityByEmail(email)) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "ALREADY EXIST EMAIL");
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity signup(@RequestBody SignUpDTO signUpDTO) throws CustomException {
        String companyCode = signUpDTO.getCompanyCode();
        String companyName = signUpDTO.getCompanyName();

        Boolean isBoss;
        if (companyCode.equals("")) isBoss = true;
        else isBoss = false;

        if (!isBoss && !companyHandler.existsCompanyEntityByCode(companyCode)) {
            throw new CustomException(ExceptionConstants.ExceptionClass.COMPANY, HttpStatus.NOT_FOUND, "NOT EXIST COMPANY CODE");
        }
        if (companyHandler.existsCompanyEntityByCompanyName(companyName)) {
            throw new CustomException(ExceptionConstants.ExceptionClass.COMPANY, HttpStatus.BAD_REQUEST, "ALREADY EXIST COMPANY NAME");
        }
        if (companyName.contains(" ")){
            throw new CustomException(ExceptionConstants.ExceptionClass.COMPANY, HttpStatus.BAD_REQUEST, "EMPTY LETTER EXIST");
        }

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

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(CustomException e) {
        HttpHeaders responseHeaders = new HttpHeaders();

        Map<String, String> map = new HashMap<>();
        map.put("type", e.getHttpStatusType());
        map.put("code", Integer.toString(e.getHttpStatusCode()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, e.getHttpStatus());
    }
}
