package com.example.demo.company.exception;

import com.example.demo.company.common.DomainException;

/**
 * packageName    : com.example.demo.company.exception
 * fileName       : ProductDomainException
 * author         : AngryPig123
 * date           : 2024-03-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-25        AngryPig123       최초 생성
 */
public class ProductDomainException extends DomainException {

    public ProductDomainException(String message) {
        super(message);
    }

    public ProductDomainException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
