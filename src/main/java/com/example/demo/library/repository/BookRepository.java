package com.example.demo.library.repository;

import com.example.demo.library.entity.Book;
import com.example.demo.library.vo.BookId;

public interface BookRepository {
    Book findBookById(BookId bookId);
}
