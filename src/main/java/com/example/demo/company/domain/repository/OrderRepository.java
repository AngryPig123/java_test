package com.example.demo.company.domain.repository;

import com.example.demo.company.domain.entity.Order;

/**
 * packageName    : com.example.demo.company.domain.repository
 * fileName       : OrderRepository
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */
public interface OrderRepository {
    void save(Order order);
}
