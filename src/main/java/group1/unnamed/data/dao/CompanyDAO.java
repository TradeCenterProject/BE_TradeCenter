package group1.unnamed.data.dao;

import group1.unnamed.data.entity.CompanyEntity;

public interface CompanyDAO {

    CompanyEntity getCompany(int companyId);

    CompanyEntity getCompanyByCompanyCode(String companyCode);

    CompanyEntity addCompany(CompanyEntity companyEntity);

    Boolean existsCompanyByCompanyCode(String companyCode);
    Boolean existsCompanyByCompanyName(String companyName);
}
