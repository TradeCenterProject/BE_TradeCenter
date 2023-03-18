package group1.unnamed.controller;

import group1.unnamed.data.dto.LoginDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.exception.CustomException;
import group1.unnamed.exception.ExceptionConstants;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.UserHandler;
import group1.unnamed.service.UserService;
import group1.unnamed.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins= "http://localhost:3000", allowedHeaders = "*")
public class UserController {

    Encryption encryption;
    UserService userService;
    UserHandler userHandler;
    CompanyHandler companyHandler;

    @Autowired
    public UserController(Encryption encryption, UserService userService, UserHandler userHandler, CompanyHandler companyHandler) {
        this.encryption = encryption;
        this.companyHandler = companyHandler;
        this.userHandler = userHandler;
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) throws CustomException {

        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        UserEntity userEntity = userHandler.getUserEntityByEmail(email);

        if (!userHandler.isUserEntityByEmail(email)) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "NOT EXIST EMAIL");
        }
        if (!userEntity.getPassword().equals(encryption.getEncrypt(userEntity.getSalt(), password))) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "INVALID PASSWORD");
        }

        return userService.loginUser(loginDTO, request, response);
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
        String email = signUpDTO.getEmail();
        String password = signUpDTO.getPassword();
        String name = signUpDTO.getName();
        String companyCode = signUpDTO.getCompanyCode();
        String companyName = signUpDTO.getCompanyName();

        if (email == null || email.equals("")) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID EMAIL");
        }
        if (userHandler.isUserEntityByEmail(email)) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "ALREADY EXIST EMAIL");
        }
        if (password == null || password.equals("")) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID PASSWORD");
        }
        if (name == null || name.equals("")) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID NAME");
        }
        if (companyCode == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID COMPANY CODE");
        }
        if (companyName == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID COMPANY NAME");
        }
        if (companyCode == "" && companyName == "") {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.BAD_REQUEST, "INVALID COMPANY INFORMATION");
        }
        if (!companyCode.equals("") && !companyHandler.existsCompanyEntityByCode(companyCode)) {
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
