package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.StockDAO;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDAOImpl implements StockDAO {

    StockRepository stockRepository;

    @Autowired
    public StockDAOImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<StockEntity> getStocksByCompanyId(int companyId) {
        return stockRepository.findAllByCompanyEntity_Id(companyId);
    }

    @Override
    public List<StockEntity> addStocks(List<StockEntity> stockEntities) {
        return stockRepository.saveAll(stockEntities);
    }

}
