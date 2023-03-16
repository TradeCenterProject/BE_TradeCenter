package group1.unnamed.service.impl;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.UserHandler;
import group1.unnamed.service.CompanyService;
import group1.unnamed.service.UserService;
import group1.unnamed.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompanyServiceImpl implements CompanyService {

    UserHandler userHandler;
    CompanyHandler companyHandler;
    Encryption encryption;

    @Autowired
    public CompanyServiceImpl(UserHandler userHandler, CompanyHandler companyHandler, Encryption encryption) {
        this.userHandler = userHandler;
        this.companyHandler = companyHandler;
        this.encryption = encryption;
    }


}
