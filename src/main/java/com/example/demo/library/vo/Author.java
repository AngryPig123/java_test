package com.example.demo.library.vo;

import java.time.LocalDate;

public class Author {

    private final String name;
    private final LocalDate birth;
    private final Nation nation;
    private final String description;

    public Author(String name, LocalDate birth, Nation nation, String description) {
        this.name = name;
        this.birth = birth;
        this.nation = nation;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public Nation getNation() {
        return nation;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", birth=" + birth.toString() +
                ", nation=" + nation +
                ", description='" + description + '\'' +
                '}';
    }

}
