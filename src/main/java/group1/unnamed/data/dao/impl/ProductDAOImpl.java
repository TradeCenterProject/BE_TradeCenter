package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.ProductDAO;
import group1.unnamed.data.entity.ProductEntity;
import group1.unnamed.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity getProduct(int productId) {
        return productRepository.getReferenceById(productId);
    }

    @Override
    public List<ProductEntity> getProductsByCompanyId(int companyId) {
        return productRepository.findAllByCompanyEntity_Id(companyId);
    }

    @Override
    public List<ProductEntity> addProducts(List<ProductEntity> productEntities) {
        return productRepository.saveAll(productEntities);
    }

}
