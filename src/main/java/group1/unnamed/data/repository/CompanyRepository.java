package group1.unnamed.data.repository;

import group1.unnamed.data.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

    CompanyEntity findByCode(String code);
    Boolean existsByCode(String code);
    Boolean existsByName(String companyName);
}
