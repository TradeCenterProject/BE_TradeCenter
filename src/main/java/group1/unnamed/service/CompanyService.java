package group1.unnamed.service;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.object.UserInfo;

public interface CompanyService {

    CompanyEntity addCompany(CompanyDTO companyDTO);

}
