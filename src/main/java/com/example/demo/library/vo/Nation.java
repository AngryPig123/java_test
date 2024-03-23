package com.example.demo.library.vo;

public class Nation {
    private final String name;

    public Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "name='" + name + '\'' +
                '}';
    }

}
