package com.example.demo.company.domain.entity;

import com.example.demo.company.common.AggregateRoot;
import com.example.demo.company.exception.OrderDomainException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * packageName    : com.example.demo.company.domain.entity
 * fileName       : Order
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
public class Order extends AggregateRoot {

    private final Customer customer;
    private final List<OrderProduct> orderProducts;
    private List<String> failureMessage;
    private int totalPrice;

    public void validate() {
        ignoreValidate();   //  제외된 브랜드 검증
        quantityValidate(); //  갯수 검증
    }

    public void init() {
        totalPrice();   //  전체 가격 설정
        saleInject();   //  할인률 설정
    }

    private void saleInject() {

        List<Integer> salePriceCase = new ArrayList<>();

        int quantityCheck = orderProducts.stream().mapToInt(OrderProduct::getOrderQuantity).sum();

        int quantitySale = quantityCheck >= 10
                ? (int) (totalPrice * 0.92)
                : totalPrice;
        int gradeSale = (int) (totalPrice * customer.getCustomerGrade().sale);
        int _50Sale = totalPrice - 50000;

        salePriceCase.add(quantitySale);
        salePriceCase.add(gradeSale);
        salePriceCase.add(_50Sale);

        totalPrice = salePriceCase.stream().min(Integer::compareTo).get();

    }   //  할인률 적용


    private void totalPrice() {

        int totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts) {
            totalPrice = totalPrice + orderProduct.getOrderQuantity() * orderProduct.getProduct().getPrice();
        }
        this.totalPrice = totalPrice;

    }   //  전체 가격 가져오기

    private void productQuantityUpdate() {

    }

    private void ignoreValidate() {

        boolean ignoreBrand = orderProducts.stream()
                .map(OrderProduct::getProduct)
                .map(Product::getBrand)
                .anyMatch(brand -> brand.getName().equalsIgnoreCase("nike"));

        if (ignoreBrand) throw new OrderDomainException("NIKE 제품은 구매하실 수 없습니다.");

    }   //  특정 브랜드의 제품은 판매할 수 없다.

    private void quantityValidate() {

        List<OrderProduct> failureList = orderProducts.stream()
                .filter(orderProduct ->
                        orderProduct.getOrderQuantity() > orderProduct.getProduct().getQuantity() ||
                                orderProduct.getProduct().getQuantity() <= 0
                ).toList();

        if (!failureList.isEmpty()) {
            failureList.forEach(orderProduct -> {
                Product product = orderProduct.getProduct();
                failureMessage.add(
                        String.format(
                                "%s 제품 수량이 0이거나 %s 제품의 수량이 주문 수량 %s보다 작습니다",
                                product.getName(), product.getName(), orderProduct.getOrderQuantity()
                        )
                );
            });
            throw new OrderDomainException(String.join(",", failureMessage));
        }   //  주문 수량이 안맞으면 구매할 수 없다.

    }

}
