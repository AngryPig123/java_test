package com.example.demo.company.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.company.domain.vo
 * fileName       : Sale
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
public class Sale {
    private final boolean sale;
    private final float discount;
}
