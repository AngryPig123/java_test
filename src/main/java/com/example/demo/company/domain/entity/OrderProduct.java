package com.example.demo.company.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * packageName    : com.example.demo.company
 * fileName       : OrderProduct
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */

@Getter
@AllArgsConstructor
public class OrderProduct {

    private final Long orderId;
    private final Product product;
    private final int orderQuantity;

}
