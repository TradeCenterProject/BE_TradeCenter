package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.CompanyDAO;
import group1.unnamed.data.dao.StockDAO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.StockHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CompanyHandlerImpl implements CompanyHandler {

    CompanyDAO companyDAO;

    @Autowired
    public CompanyHandlerImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public CompanyEntity getCompanyEntity(int companyId) {
        return companyDAO.getCompany(companyId);
    }
}
