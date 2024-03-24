package com.example.demo.library.entity;

import com.example.demo.library.vo.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static com.example.demo.library.vo.RentalStatus.STEP1;
import static com.example.demo.library.vo.RentalStatus.STEP2;

public class BookRental {

    //  도서관
    //  대여, 반납, 조회, 회원 관리

    private final UUID id;
    private final Book book;
    private final Member member;
    private DateInfo dateInfo;
    private RentalStatus rentalStatus;
    private BigDecimal price;

    private void validate() {
        if (book == null) {
            throw new IllegalStateException("대출 할 책을 다시 확인해 주세요.");
        }
        if (member == null) {
            throw new IllegalStateException("대출 고객을 다시 확인해 주세요.");
        }
    }

    public void startRental() {
        validate();
        book.rentalBook();
        this.dateInfo = new DateInfo(LocalDate.now());
        this.rentalStatus = STEP1;
        this.price = book.getPrice().multiply(new BigDecimal(member.getMemberGrade().value));
    }

    public void bookReturn() {
        validate();
        book.returnBook();
        this.dateInfo = new DateInfo(LocalDate.now());
        this.rentalStatus = STEP2;
    }

    public BookRental(Book book, Member member) {
        this.id = UUID.randomUUID();
        this.book = book;
        this.member = member;
    }

}
