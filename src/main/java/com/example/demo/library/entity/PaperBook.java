package com.example.demo.library.entity;

import com.example.demo.library.vo.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class PaperBook extends Book {

    private final DamageLevel damageLevel;

    public PaperBook(
            BookId id, String title, List<Author> authors, DateInfo dateInfo, Genre genre, UUID isbn, BigDecimal price,
            int page, Tag tag, short rentalCount, boolean rentalAvailability, DamageLevel damageLevel
    ) {
        super(id, title, authors, dateInfo, genre, isbn, price, page, tag, rentalCount, rentalAvailability);
        this.damageLevel = damageLevel;
    }

    public DamageLevel getDamageLevel() {
        return damageLevel;
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply(new BigDecimal(this.damageLevel.value)).setScale(0, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
