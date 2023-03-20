package group1.unnamed.service.impl;

import group1.unnamed.data.dto.ProductDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.ProductEntity;
import group1.unnamed.handler.CompanyHandler;
import group1.unnamed.handler.ProductHandler;
import group1.unnamed.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductHandler productHandler;
    CompanyHandler companyHandler;

    @Autowired
    public ProductServiceImpl(ProductHandler productHandler, CompanyHandler companyHandler) {
        this.productHandler = productHandler;
        this.companyHandler = companyHandler;
    }

    @Override
    public List<ProductDTO> getProductList(int companyId) {
        List<ProductEntity> productEntities = productHandler.getProductEntitiesByCompanyId(companyId);

        List<ProductDTO> products = new ArrayList<>();

        for (int i=0; i<productEntities.size(); i++) {
            ProductEntity productEntity = productEntities.get(i);

            ProductDTO productDTO = new ProductDTO(productEntity.getProductCode(), productEntity.getProductName(), productEntity.getProductCompany(), productEntity.getProductCategory(), productEntity.getLocation(), productEntity.getPrice(), productEntity.getQuantity());

            products.add(productDTO);
        }

        return products;
    }

    @Override
    public List<ProductDTO> addProducts(int companyId, List<ProductDTO> products) {
        CompanyEntity companyEntity = companyHandler.getCompanyEntity(companyId);

        List<ProductEntity> productEntities = new ArrayList<>();

        for (int i=0; i<products.size(); i++) {
            ProductDTO stock = products.get(i);

            ProductEntity productEntity = new ProductEntity(companyEntity, stock.getProductCode(), stock.getProductName(), stock.getProductCompany(), stock.getProductCategory(), stock.getLocation(), stock.getPrice(), stock.getQuantity());

            productEntities.add(productEntity);
        }

        productHandler.addProductEntities(productEntities);

        return getProductList(companyId);
    }
}
