package group1.unnamed.data.dao;

import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;

import java.util.List;

public interface CompanyDAO {

    CompanyEntity getCompany(int companyId);

    CompanyEntity getCompanyByCode(String code);

    CompanyEntity addCompany(CompanyEntity companyEntity);

    Boolean isCompanyByCode(String code);
}
