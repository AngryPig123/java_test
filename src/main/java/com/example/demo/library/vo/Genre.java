package com.example.demo.library.vo;

import java.util.List;

public class Genre {

    private final List<GenreType> genreTypeList;

    public Genre(List<GenreType> genreTypeList) {
        this.genreTypeList = genreTypeList;
    }

    public List<GenreType> getGenreTypeList() {
        return genreTypeList;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreTypeList=" + genreTypeList +
                '}';
    }

}
