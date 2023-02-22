package group1.unnamed.service.impl;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.StockHandler;
import group1.unnamed.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    StockHandler stockHandler;
    CompanyHandler companyHandler;

    @Autowired
    public StockServiceImpl(StockHandler stockHandler, CompanyHandler companyHandler) {
        this.stockHandler = stockHandler;
        this.companyHandler = companyHandler;
    }

    @Override
    public List<StockDTO> getStockList(int companyId) {
        List<StockEntity> stockEntities = stockHandler.getStockEntitiesByCompanyId(companyId);

        List<StockDTO> stocks = new ArrayList<>();

        for (int i=0; i<stockEntities.size(); i++) {
            StockEntity stockEntity = stockEntities.get(i);

            StockDTO stockDTO = new StockDTO(stockEntity.getId(), stockEntity.getCode(), stockEntity.getName(), stockEntity.getProducer(), stockEntity.getLocation(), stockEntity.getPrice(), stockEntity.getAmount());

            stocks.add(stockDTO);
        }

        return stocks;
    }

    @Override
    public List<StockDTO> addStocks(int companyId, List<StockDTO> stocks) {
        CompanyEntity companyEntity = companyHandler.getCompanyEntity(companyId);

        List<StockEntity> stockEntities = new ArrayList<>();

        for (int i=0; i<stocks.size(); i++) {
            StockDTO stock = stocks.get(i);

            StockEntity stockEntity = new StockEntity(companyEntity, stock.getCode(), stock.getName(), stock.getProducer(), stock.getLocation(), stock.getPrice(), stock.getAmount());

            stockEntities.add(stockEntity);
        }

        stockHandler.addStockEntities(stockEntities);

        return getStockList(companyId);
    }
}
