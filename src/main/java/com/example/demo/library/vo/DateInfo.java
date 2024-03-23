package com.example.demo.library.vo;

import java.time.LocalDate;

public class DateInfo {

    private final LocalDate createdDate;

    public DateInfo(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "DateInfo{" +
                "createdDate=" + createdDate.toString() +
                '}';
    }

}
