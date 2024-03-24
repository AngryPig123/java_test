package com.example.demo.library.entity;

import com.example.demo.library.vo.DateInfo;
import com.example.demo.library.vo.MemberGrade;
import com.example.demo.library.vo.RentalStatus;

import java.math.BigDecimal;
import java.util.List;

public class BookRental {

    //  도서관
    //  대여, 반납, 조회, 회원 관리

    private final Long id;
    private final Book book;
    private final Member member;
    private final DateInfo dateInfo;
    private final RentalStatus rentalStatus;
    private BigDecimal price;

    public void validate() {
        if (member.getMemberGrade() == MemberGrade.BLACK) throw new RuntimeException();
    }

    private void setPrice() {
        this.price = this.price.multiply(new BigDecimal(member.getMemberGrade().value));
    }

    public BookRental(Long id, Book book, Member member, BigDecimal price, DateInfo dateInfo, RentalStatus rentalStatus) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.price = price;
        this.dateInfo = dateInfo;
        this.rentalStatus = rentalStatus;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DateInfo getDateInfo() {
        return dateInfo;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

}
