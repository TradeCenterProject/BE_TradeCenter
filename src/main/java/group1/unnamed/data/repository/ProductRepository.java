package group1.unnamed.data.repository;

import group1.unnamed.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findAllByCompanyEntity_Id(int companyId);


}
