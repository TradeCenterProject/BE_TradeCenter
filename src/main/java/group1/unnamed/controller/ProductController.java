package group1.unnamed.controller;

import group1.unnamed.data.dto.ProductDTO;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.exception.CustomException;
import group1.unnamed.exception.ExceptionConstants;
import group1.unnamed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public List<ProductDTO> getProductList(HttpServletRequest request) throws CustomException {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "INVALID SESSION");
        }
        UserEntity userEntity = (UserEntity) session.getAttribute("signIn");

        return productService.getProductList(userEntity.getCompanyEntity().getId());
    }

    @PostMapping(value = "")
    public List<ProductDTO> addProducts(@RequestBody List<ProductDTO> products, HttpServletRequest request) throws CustomException {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "INVALID SESSION");
        }

        UserEntity userEntity = (UserEntity) session.getAttribute("signIn");

        productService.addProducts(userEntity.getCompanyEntity().getId(), products);

        return productService.getProductList(userEntity.getCompanyEntity().getId());
    }
}
