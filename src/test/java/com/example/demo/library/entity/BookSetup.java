package com.example.demo.library.entity;

import com.example.demo.library.vo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public abstract class BookSetup extends DetailInfoData {

    protected BookId createBookId() {
        return new BookId(UUID.randomUUID());
    }

    protected String createTitle() {
        return titles[new Random().nextInt(titles.length)];
    }

    protected List<Author> createAuthors() {
        return super.createAuthors();
    }

    protected DateInfo createDateInfo() {
        return super.createDateInfo();
    }

    protected Genre createGenre() {
        return new Genre(List.of(GenreType.getRandomGenreType()));
    }

    protected UUID createIsbn() {
        return UUID.randomUUID();
    }

    protected BigDecimal createPrice() {
        BigDecimal min = new BigDecimal(9500);
        BigDecimal max = new BigDecimal(24000);
        Random random = new Random();
        double randomValue = min.doubleValue() + (max.doubleValue() - min.doubleValue()) * random.nextDouble();
        return BigDecimal.valueOf((int) randomValue);
    }

    protected int createPage() {
        return new Random().nextInt(200) + 100;
    }

    protected Tag createTag() {
        int randomTag = new Random().nextInt(3) + 1;
        return new Tag(randomTag + "v");
    }

    protected short createRentalCount() {
        return (short) (new Random().nextInt(20) + 1);
    }

    protected boolean createRentalAvailability() {
        return new Random().nextBoolean();
    }

}
