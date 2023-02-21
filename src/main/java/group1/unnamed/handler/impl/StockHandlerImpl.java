package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.StockDAO;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.handler.StockHandler;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockHandlerImpl implements StockHandler {

    StockDAO stockDAO;

    @Autowired
    public StockHandlerImpl(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    @Override
    public List<StockEntity> getStockEntitiesByCompanyId(int companyId) {
        return stockDAO.getStocksByCompanyId(companyId);
    }

    @Override
    public List<StockEntity> addStockEntities(List<StockEntity> stockEntities) {
        return stockDAO.addStocks(stockEntities);
    }
}
