package com.example.demo.library.entity;

import com.example.demo.library.vo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public abstract class Book {

    private final BookId id;
    private final String title;
    private final List<Author> authors;
    private final DateInfo dateInfo;
    private final Genre genre;
    private final UUID isbn;
    private final BigDecimal price;
    private final int page;
    private final Tag tag;
    private short rentalCount;
    private boolean rentalAvailability;

    public String printBookInfo() {
        return String.format(
                "title : %s, Genre : %s, Authors : %s, price : %s, rentalCount : %s, rentalAvailability : %s",
                this.title, this.genre, this.authors, this.price, this.rentalCount, this.rentalAvailability
        );
    }

    public void rentalBook() {
        if (this.rentalAvailability) {
            this.rentalCount++;
            this.rentalAvailability = false;
        }
    }

    public void returnBook() {
        if (!this.rentalAvailability) {
            this.rentalAvailability = true;
        }
    }

    public Book(BookId id, String title, List<Author> authors, DateInfo dateInfo, Genre genre, UUID isbn, BigDecimal price, int page, Tag tag, short rentalCount, boolean rentalAvailability) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.dateInfo = dateInfo;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.page = page;
        this.tag = tag;
        this.rentalCount = rentalCount;
        this.rentalAvailability = rentalAvailability;
    }

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public DateInfo getDateInfo() {
        return dateInfo;
    }

    public Genre getGenre() {
        return genre;
    }

    public UUID getIsbn() {
        return isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getPage() {
        return page;
    }

    public Tag getTag() {
        return tag;
    }

    public short getRentalCount() {
        return rentalCount;
    }

    public boolean isRentalAvailability() {
        return rentalAvailability;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", dateInfo=" + dateInfo +
                ", genre=" + genre +
                ", isbn=" + isbn +
                ", price=" + price +
                ", page=" + page +
                ", tag=" + tag +
                ", rentalCount=" + rentalCount +
                ", rentalAvailability=" + rentalAvailability +
                '}';
    }

}
