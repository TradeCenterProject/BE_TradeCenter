package group1.unnamed.data.dao;

import group1.unnamed.data.entity.StockEntity;

import java.util.List;

public interface StockDAO {

    StockEntity getStock(int stockId);
    List<StockEntity> getStocksByCompanyId(int companyId);
    List<StockEntity> addStocks(List<StockEntity> stockEntities);
}
