package group1.unnamed.service.impl;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.*;
import group1.unnamed.handler.*;
import group1.unnamed.service.UserService;
import group1.unnamed.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    UserHandler userHandler;
    CompanyHandler companyHandler;
    Encryption encryption;

    @Autowired
    public UserServiceImpl(UserHandler userHandler, CompanyHandler companyHandler, Encryption encryption) {
        this.userHandler = userHandler;
        this.companyHandler = companyHandler;
        this.encryption = encryption;
    }

    @Override
    public ResponseEntity signupUser(SignUpDTO signUpDTO) {
        String email = signUpDTO.getEmail();
        String name = signUpDTO.getName();
        String password = signUpDTO.getPassword();

        String companyCode = signUpDTO.getCompanyCode();
        String companyName = signUpDTO.getCompanyName();

        Boolean isBoss;
        if (companyCode.equals("")) isBoss = true;
        else isBoss = false;

        String salt = encryption.getSalt(20);
        String encryptedPassword = encryption.getEncrypt(salt, password);

        UserEntity userEntity;

        if (isBoss) {
            String code = encryption.getSalt(3);
            CompanyEntity companyEntity = companyHandler.addCompanyEntity(new CompanyEntity(companyName, code, LocalDate.now().toString()));
            userEntity = new UserEntity(companyEntity, name, email, encryptedPassword, salt, isBoss);
        }
        else {
            CompanyEntity companyEntity = companyHandler.getCompanyEntityByCode(companyCode);
            userEntity = new UserEntity(companyEntity, name, email, encryptedPassword, salt, isBoss);
        }

        userHandler.addUserEntity(userEntity);

        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @Override
//    public ResponseEntity loginUser(LoginDTO loginDTO, HttpServletRequest request) {
//        String email = loginDTO.getEmail();
//
//        UserEntity userEntity = userHandler.getUserEntityByEmail(email);
//
//        HttpSession session = request.getSession();
//
//        session.setAttribute("signIn", userEntity);
//
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @Override
    public String loginUser(LoginDTO loginDTO, HttpServletRequest request) {
        String email = loginDTO.getEmail();

        UserEntity userEntity = userHandler.getUserEntityByEmail(email);

        HttpSession session = request.getSession();

        session.setAttribute("signIn", userEntity);

        return session.getId();
    }

    @Override
    public Object logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return null;
    }
}
