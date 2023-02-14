package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.CompanyDAO;
import group1.unnamed.data.dao.StockDAO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.repository.CompanyRepository;
import group1.unnamed.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyDAOImpl implements CompanyDAO {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyDAOImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public CompanyEntity getCompany(int companyId) {
        return companyRepository.getReferenceById(companyId);
    }
}
