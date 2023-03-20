package group1.unnamed.handler;

import group1.unnamed.data.entity.ProductEntity;

import java.util.List;

public interface ProductHandler {

    ProductEntity getProductEntity(int productId);
    List<ProductEntity> getProductEntitiesByCompanyId(int companyId);
    List<ProductEntity> addProductEntities(List<ProductEntity> productEntities);
}
