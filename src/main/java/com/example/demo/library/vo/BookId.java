package com.example.demo.library.vo;

import java.util.UUID;

public class BookId {
    private final UUID id;

    public BookId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BookId{" +
                "id=" + id +
                '}';
    }

}
