package group1.unnamed.controller;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.data.dto.StockListDTO;
import group1.unnamed.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class StockController {

    StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "")
    public StockListDTO getStockList() {

        return stockService.getStockList(1);
    }

    @PostMapping(value = "")
    public StockListDTO addStocks(@RequestBody StockListDTO stockListDTO) {
        stockService.addStocks(1, stockListDTO);

        return stockService.getStockList(1);
    }
}
