package com.example.demo.company.domain;

import com.example.demo.company.domain.entity.Admin;
import com.example.demo.company.domain.entity.Product;
import com.example.demo.company.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;

/**
 * packageName    : com.example.demo.company.domain
 * fileName       : ProductManagementService
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */

@AllArgsConstructor
public class ProductManagementService {

    private final ProductRepository productRepository;
    
    public void insertProduct(Admin admin, Product product) {
        admin.productDomainValidate();
        product.validate();
        product.init();
        productRepository.save(product);
    }

    public void updateProduct(Product product, Product updateInfo) {
        product.update(updateInfo);
        productRepository.update(product);
    }

    public void deleteProduct(Long id) {
        Product deleteProduct = productRepository.findProductById(id);
        deleteProduct.delete();
        productRepository.deleteById(id);
    }

}
