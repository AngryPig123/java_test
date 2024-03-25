package com.example.demo.company.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.company.domain.vo
 * fileName       : CustomerGrade
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
public enum CustomerGrade {
    BRONZE(0.95f),
    SILVER(0.90f),
    GOLD(0.85f);
    public final float sale;
}
