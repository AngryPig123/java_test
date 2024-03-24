package com.example.demo.library.repository;

import com.example.demo.library.entity.BookRental;

public interface RentalRepository {

    void insertRentalHistory(BookRental bookRental);

    void changeToReturnStatus(BookRental bookRental);

}
