package com.example.demo.library.entity;

import com.example.demo.library.vo.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class EBook extends Book {

    private Display display;

    public EBook(
            BookId id, String title, List<Author> authors, DateInfo dateInfo, Genre genre, UUID isbn, BigDecimal price, int page,
            Tag tag, short rentalCount, boolean rentalAvailability, Display display
    ) {
        super(id, title, authors, dateInfo, genre, isbn, price, page, tag, rentalCount, rentalAvailability);
        this.display = display;
    }

    public void changeDisplay(Display display) {
        this.display = display;
    }   //  해상도를 바꾼다.

    public Display getDisplay() {
        return display;
    }   //  해상도를 가져온다.

}
