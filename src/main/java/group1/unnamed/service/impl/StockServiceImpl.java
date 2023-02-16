package group1.unnamed.service.impl;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.data.dto.StockListDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.StockHandler;
import group1.unnamed.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public StockListDTO getStockList(int companyId) {
        List<StockEntity> stockEntities = stockHandler.getStockEntitiesByCompanyId(companyId);

        return new StockListDTO(stockEntities);
    }

    @Override
    public StockListDTO addStock(int companyId, StockDTO stockDTO) {
        CompanyEntity companyEntity = companyHandler.getCompanyEntity(companyId);
        System.out.println(companyEntity.getId());
        System.out.println(companyEntity.getCode());
        System.out.println(companyEntity.getName());
        StockEntity stockEntity = new StockEntity(companyEntity, stockDTO.getCode(), stockDTO.getName(), stockDTO.getProducer(), stockDTO.getLocation(), stockDTO.getPrice(), stockDTO.getAmount());
        stockHandler.addStockEntity(stockEntity);

        List<StockEntity> stockEntities = stockHandler.getStockEntitiesByCompanyId(companyId);

        return new StockListDTO(stockEntities);
    }
}
