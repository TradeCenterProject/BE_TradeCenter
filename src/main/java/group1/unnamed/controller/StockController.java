package group1.unnamed.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class StockController {

    @GetMapping(value = "")
    public Object getStockList() {

        Object object = null;

        return object;
    }
}
