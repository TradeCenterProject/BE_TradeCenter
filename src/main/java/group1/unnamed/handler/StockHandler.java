package group1.unnamed.handler;

import group1.unnamed.data.entity.StockEntity;

import java.util.List;

public interface StockHandler {

    StockEntity getStockEntity(int stockId);
    List<StockEntity> getStockEntitiesByCompanyId(int companyId);
    List<StockEntity> addStockEntities(List<StockEntity> stockEntities);
}
