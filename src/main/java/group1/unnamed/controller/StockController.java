package group1.unnamed.controller;

import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(originPatterns= "*", allowedHeaders = "*", allowCredentials = "True")
public class StockController {

    StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "")
    public List<StockDTO> getStockList() {

        return stockService.getStockList(1);
    }

    @PostMapping(value = "")
    public List<StockDTO> addStocks(@RequestBody List<StockDTO> stocks) {
        stockService.addStocks(1, stocks);

        return stockService.getStockList(1);
    }
}
