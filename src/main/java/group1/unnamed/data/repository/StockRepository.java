package group1.unnamed.data.repository;

import group1.unnamed.data.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {

    List<StockEntity> findAllByCompanyEntity_Id(int companyId);
}
