package com.example.demo.library.vo;

import java.util.UUID;

public class MemberId {
    private final UUID id;

    public MemberId(UUID id) {
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
