package group1.unnamed.service;

import group1.unnamed.data.dto.StockDTO;

import java.util.List;

public interface StockService {

    List<StockDTO> getStockList(int companyId);
    List<StockDTO> addStocks(int companyId, List<StockDTO> stocks);

}
