package group1.unnamed.service.impl;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.handler.StockHandler;
import group1.unnamed.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    StockHandler stockHandler;

    @Autowired
    public StockServiceImpl(StockHandler stockHandler) {
        this.stockHandler = stockHandler;
    }

    @Override
    public StockDTO getStockList(int companyId) {
        List<StockEntity> stockEntities = stockHandler.getStockEntitiesByCompanyId(companyId);

        return new StockDTO(stockEntities);
    }
}
