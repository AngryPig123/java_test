package com.example.demo.company.domain;

import com.example.demo.company.domain.entity.Order;
import com.example.demo.company.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.example.demo.company.domain
 * fileName       : OrderService
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */

@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void orderStart(Order order) {
        order.validate();
        order.init();
        orderRepository.save(order);
    }

}
