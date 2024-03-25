package com.example.demo.company.domain.repository;

import com.example.demo.company.domain.entity.Product;

/**
 * packageName    : com.example.demo.company.domain.repository
 * fileName       : ProductRepository
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */
public interface ProductRepository {
    void save(Product product);

    void update(Product product);

    Product findProductById(Long id);

    void deleteById(Long id);
}
