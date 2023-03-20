package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.CompanyDAO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public CompanyEntity getCompanyByCompanyCode(String code) {
        return companyRepository.findByCompanyCode(code);
    }

    @Override
    public CompanyEntity addCompany(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public Boolean existsCompanyByCompanyCode(String companyCode) {
        return companyRepository.existsByCompanyCode(companyCode);
    }

    @Override
    public Boolean existsCompanyByCompanyName(String companyName) {
        return companyRepository.existsByCompanyName(companyName);
    }
}
