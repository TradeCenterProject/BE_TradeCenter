package group1.unnamed.controller;

import group1.unnamed.data.dto.ProductDTO;
import group1.unnamed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins= "http://localhost:3000", allowedHeaders = "*")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public List<ProductDTO> getProductList() {

        return productService.getProductList(1);
    }

    @PostMapping(value = "")
    public List<ProductDTO> addProducts(@RequestBody List<ProductDTO> products) {
        productService.addProducts(1, products);

        return productService.getProductList(1);
    }
}
