package group1.unnamed.data.dao;

import group1.unnamed.data.entity.ProductEntity;

import java.util.List;

public interface ProductDAO {

    ProductEntity getProduct(int productId);
    List<ProductEntity> getProductsByCompanyId(int companyId);
    List<ProductEntity> addProducts(List<ProductEntity> productEntities);
}
