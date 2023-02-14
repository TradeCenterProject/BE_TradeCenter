package group1.unnamed.service;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.data.dto.StockListDTO;

public interface StockService {

    StockListDTO getStockList(int companyId);
    StockListDTO addStock(int companyId, StockDTO stockDTO);

}
