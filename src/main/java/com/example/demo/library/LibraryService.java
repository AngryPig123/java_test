package com.example.demo.library;

import com.example.demo.library.entity.Book;
import com.example.demo.library.entity.BookRental;
import com.example.demo.library.entity.Member;
import com.example.demo.library.repository.BookRepository;
import com.example.demo.library.repository.MemberRepository;
import com.example.demo.library.repository.RentalRepository;
import jakarta.transaction.Transactional;


public class LibraryService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final RentalRepository rentalRepository;

    public LibraryService(BookRepository bookRepository, MemberRepository memberRepository, RentalRepository rentalRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.rentalRepository = rentalRepository;
    }

    @Transactional
    public void rentalService(Book book, Member member) {
        BookRental bookRental = findBookRentalHelper(book, member);
        bookRental.startRental();
        rentalRepository.insertRentalHistory(bookRental);
    }

    @Transactional
    public void returnService(Book book, Member member) {
        BookRental bookRental = findBookRentalHelper(book, member);
        bookRental.bookReturn();
        rentalRepository.changeToReturnStatus(bookRental);
    }

    
    private BookRental findBookRentalHelper(Book book, Member member) {
        Member findMember = memberRepository.findMemberById(member.getMemberId());
        Book findBook = bookRepository.findBookById(book.getId());
        BookRental bookRental = new BookRental(findBook, findMember);
        return bookRental;
    }

}
