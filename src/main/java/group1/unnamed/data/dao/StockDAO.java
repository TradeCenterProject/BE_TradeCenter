package group1.unnamed.data.dao;

import group1.unnamed.data.entity.StockEntity;

import java.util.List;

public interface StockDAO {

    List<StockEntity> getStocksByCompanyId(int companyId);
}
