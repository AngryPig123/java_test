package com.example.demo.company.domain.entity;

import com.example.demo.company.domain.vo.AdminType;
import com.example.demo.company.exception.ProductDomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.company
 * fileName       : Admin
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
public class Admin {

    private final AdminType adminType;

    public void productDomainValidate() {
        if (adminType != AdminType.PRODUCT) throw new ProductDomainException("상품 등록 권한이 없습니다.");
    }

}
