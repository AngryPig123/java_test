package com.example.demo.library.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

class PaperBookTest extends PaperBookTestSetup {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void 종이_책_셋팅() throws Exception {


        for (int i = 0; i < 50; i++) {
            paperBookList.add(createBook());
        }

        System.out.println(paperBookList);

    }

}
