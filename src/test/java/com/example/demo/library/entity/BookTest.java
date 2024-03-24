package com.example.demo.library.entity;

import com.example.demo.library.vo.DamageLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BookTest extends BookTestSetup {

    @Nested
    class BookRentalReturn {

        @Test
        void 대여_성공() {
            Book book = rentalReturnTestBook((short) 1, true);
            Assertions.assertDoesNotThrow(book::rentalBook);
        }

        @Test
        void 대여_실패() {
            Book book = rentalReturnTestBook((short) 2, false);
            Assertions.assertThrows(IllegalStateException.class, book::rentalBook);
        }

        @Test
        void 반납_성공() {
            Book book = rentalReturnTestBook((short) 3, true);
            Assertions.assertThrows(IllegalStateException.class, book::returnBook);
        }

        @Test
        void 반납_실패() {
            Book book = rentalReturnTestBook((short) 4, true);
            Assertions.assertThrows(IllegalStateException.class, book::returnBook);
        }

        private Book rentalReturnTestBook(short rentalCount, boolean rentalAvailability) {
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
                    rentalCount,
                    rentalAvailability,
                    createDamageLevel()
            );
        }

    }

    @Nested
    class PaperBookPrice {

        @Test
        void 종이_책_가격_테스트_성공() {
            int price = 10000;
            Book paperBook = createPaperBook(new BigDecimal(price), DamageLevel.LV1);
            Assertions.assertEquals(new BigDecimal(price), paperBook.getPrice());
        }

        @Test
        void 종이_책_가격_테스트_실패() {
            int price = 10000;
            Book paperBook = createPaperBook(new BigDecimal(price), DamageLevel.LV2);
            Assertions.assertNotEquals(new BigDecimal(price), paperBook.getPrice());
        }

        private Book createPaperBook(BigDecimal price, DamageLevel damageLevel) {
            return new PaperBook(
                    createBookId(),
                    createTitle(),
                    createAuthors(),
                    createDateInfo(),
                    createGenre(),
                    createIsbn(),
                    price,
                    createPage(),
                    createTag(),
                    createRentalCount(),
                    createRentalAvailability(),
                    damageLevel
            );
        }

    }

}
