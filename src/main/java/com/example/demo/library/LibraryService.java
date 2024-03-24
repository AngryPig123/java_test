package com.example.demo.library;

import com.example.demo.library.entity.Book;
import com.example.demo.library.entity.BookRental;
import com.example.demo.library.entity.Member;
import com.example.demo.library.repository.BookRepository;
import com.example.demo.library.repository.MemberRepository;
import com.example.demo.library.repository.RentalRepository;
import com.example.demo.library.vo.MemberGrade;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


public class LibraryService {

    private final MemberRepository memberRepository;
    private final RentalRepository rentalRepository;

    public LibraryService(MemberRepository memberRepository, RentalRepository rentalRepository) {
        this.memberRepository = memberRepository;
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public void rentalService(Book book, Member member) {
        BookRental bookRental = new BookRental(book, member);
        bookRental.startRental();
        rentalRepository.insertRentalHistory(bookRental);
    }

    @Transactional
    public void returnService(UUID id) {
        BookRental findBookRental = rentalRepository.findBookRentalByBookId(id);
        findBookRental.bookReturn();
        isOverSixMonths(findBookRental.getMember(), findBookRental);
        rentalRepository.changeToReturnStatus(findBookRental);
        memberRepository.updateStatus(findBookRental.getMember());
    }

    private void isOverSixMonths(Member member, BookRental bookRental) {
        long monthsBetween = ChronoUnit.MONTHS.between(bookRental.getDateInfo().getCreatedDate(), LocalDate.now());
        if (monthsBetween >= 6) {
            member.updateMemberGrade(MemberGrade.BLACK);
        }
    }

}
