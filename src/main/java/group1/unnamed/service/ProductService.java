package group1.unnamed.service;

import group1.unnamed.data.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProductList(int companyId);
    List<ProductDTO> addProducts(int companyId, List<ProductDTO> products);

}
