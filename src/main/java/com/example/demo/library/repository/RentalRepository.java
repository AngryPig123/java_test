package com.example.demo.library.repository;

import com.example.demo.library.entity.BookRental;
import com.example.demo.library.vo.BookId;

import java.util.UUID;

public interface RentalRepository {

    void insertRentalHistory(BookRental bookRental);

    void changeToReturnStatus(BookRental bookRental);

    BookRental findBookRentalByBookId(UUID id); //  Join 하여 다 가져 와야함.

}
