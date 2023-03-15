package group1.unnamed.service.impl;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.*;
import group1.unnamed.data.object.TaskStock;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.handler.*;
import group1.unnamed.service.TaskService;
import group1.unnamed.service.UserService;
import group1.unnamed.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public UserInfo addUser(SignUpDTO signUpDTO) {
        String email = signUpDTO.getEmail();
        String name = signUpDTO.getName();
        String password = signUpDTO.getPassword();

        if (userHandler.isUserEntityByEmail(email)) {
            UserInfo userInfo = new UserInfo(-1, "exist_user");
            return userInfo;
        }

        String companyCode = signUpDTO.getCompanyCode();

        Boolean isAdmin;
        if (companyCode.equals("")) isAdmin = true;
        else isAdmin = false;

        if (!isAdmin && !companyHandler.isCompanyEntityByCode(companyCode)) {
            UserInfo userInfo = new UserInfo(-2, "not_exist_company");
            return userInfo;
        }

        String salt = encryption.getSalt(20);
        String encryptedPassword = encryption.getEncrypt(salt, password);

        UserEntity userEntity;

        if (!isAdmin) {
            CompanyEntity companyEntity = companyHandler.getCompanyEntityByCode(companyCode);
            userEntity = new UserEntity(companyEntity, name, email, encryptedPassword, salt, isAdmin);
        }
        else userEntity = new UserEntity(name, email, encryptedPassword, salt, isAdmin);

        UserEntity savedUserEntity = userHandler.addUserEntity(userEntity);

        UserInfo userInfo = new UserInfo(savedUserEntity.getId(), name);

        return userInfo;
    }

    @Override
    public UserInfo loginUser(LoginDTO loginDTO, HttpServletRequest request) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        if (!userHandler.isUserEntityByEmail(email)) {
            System.out.println("유저가 존재하지 않음");
            return null;
        }

        UserEntity userEntity = userHandler.getUserEntityByEmail(email);

        String encryptedPassword = encryption.getEncrypt(userEntity.getSalt(), password);

        if (!userEntity.getPassword().equals(encryptedPassword)) {
            System.out.println("비밀번호가 맞지 않음");
            return null;
        }


        HttpSession session = request.getSession();

        session.setAttribute("signIn", userEntity);

        UserInfo userInfo = new UserInfo(userEntity.getId(), userEntity.getName());

        return userInfo;
    }
}
