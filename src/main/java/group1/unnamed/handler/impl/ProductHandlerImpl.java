package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.ProductDAO;
import group1.unnamed.data.entity.ProductEntity;
import group1.unnamed.handler.ProductHandler;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductHandlerImpl implements ProductHandler {

    ProductDAO productDAO;

    @Autowired
    public ProductHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductEntity getProductEntity(int productId) {
        return productDAO.getProduct(productId);
    }

    @Override
    public List<ProductEntity> getProductEntitiesByCompanyId(int companyId) {
        return productDAO.getProductsByCompanyId(companyId);
    }

    @Override
    public List<ProductEntity> addProductEntities(List<ProductEntity> productEntities) {
        return productDAO.addProducts(productEntities);
    }
}
