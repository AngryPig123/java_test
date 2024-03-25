package com.example.demo.company.domain.entity;

import com.example.demo.company.common.AggregateRoot;
import com.example.demo.company.domain.vo.ProductStatus;
import com.example.demo.company.domain.vo.Sale;
import com.example.demo.company.exception.ProductDomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * packageName    : com.example.demo.company
 * fileName       : Product
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
public class Product extends AggregateRoot {

    private final Long id;
    private int price;
    private ProductStatus productStatus;
    private final int quantity;
    private String name;
    private Sale sale;
    private final Brand brand;
    private final Category category;

    public void validate() {

        if (name.matches(".*\\d.*")) {
            throw new ProductDomainException("상품명에는 숫자가 들어갈 수 없습니다.");
        }

        if (category == null || brand == null) {
            throw new ProductDomainException("카테고리나 브랜드는 필수 입니다.");
        }

        if (price < 0) {
            throw new ProductDomainException("상품 가격은 0 이상입니다.");
        }

        if (quantity < 0) {
            throw new ProductDomainException("상품 개수는 0 이상입니다.");
        }

    }

    public void init() {
        this.productStatus = ProductStatus.SALE;
    }

    public void delete() {
        if (productStatus == ProductStatus.SALE) {
            throw new ProductDomainException("판매중인 상품은 삭제할 수 없습니다.");
        }
    }

    public void update(Product product) {
        product.validate();
        this.name = product.name;
        this.sale = product.sale;
    }

}
