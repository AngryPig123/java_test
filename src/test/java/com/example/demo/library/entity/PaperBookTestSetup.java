package com.example.demo.library.entity;

import com.example.demo.library.vo.DamageLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class PaperBookTestSetup extends BookTestSetup {

    protected List<Book> paperBookList = new ArrayList<>();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        paperBookList.clear();
    }

    protected DamageLevel createDamageLevel() {
        return DamageLevel.getRandomGenreType();
    }

    protected Book createBook() {
        return new PaperBook(
                createBookId(),
                createTitle(),
                createAuthors(),
                createDateInfo(),
                createGenre(),
                createIsbn(),
                createPrice(),
                createPage(),
                createTag(),
                createRentalCount(),
                createRentalAvailability(),
                createDamageLevel()
        );
    }

}
