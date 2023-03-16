package group1.unnamed.handler;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;

import java.util.List;

public interface CompanyHandler {

    CompanyEntity getCompanyEntity(int companyId);

    CompanyEntity getCompanyEntityByCode(String code);

    CompanyEntity addCompanyEntity(CompanyEntity companyEntity);

    Boolean existsCompanyEntityByCode(String code);
    Boolean existsCompanyEntityByCompanyName(String companyName);

}
