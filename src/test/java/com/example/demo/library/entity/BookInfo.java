package com.example.demo.library.entity;

import com.example.demo.library.vo.Author;
import com.example.demo.library.vo.DateInfo;
import com.example.demo.library.vo.Nation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public abstract class BookInfo {

    protected String[] titles = {"Java Programming for Beginners", "Clean Code: A Handbook of Agile Software Craftsmanship", "Design Patterns: Elements of Reusable Object-Oriented Software", "Effective Java", "Head First Java", "Introduction to Algorithms", "The Pragmatic Programmer: Your Journey to Mastery", "Cracking the Coding Interview", "Refactoring: Improving the Design of Existing Code", "Code Complete: A Practical Handbook of Software Construction", "JavaScript: The Good Parts", "Eloquent JavaScript: A Modern Introduction to Programming", "Learning Python", "Python Crash Course", "Automate the Boring Stuff with Python", "Learning React: A Hands-On Guide to Building Web Applications Using React and Redux", "Node.js Design Patterns", "Learning SQL", "SQL for Dummies", "Data Structures and Algorithms in Python", "Algorithms Unlocked", "Computer Networking: A Top-Down Approach", "Operating System Concepts", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", "Domain-Driven Design: Tackling Complexity in the Heart of Software"};

    private String[] nations = {"미국 (United States of America)", "캐나다 (Canada)", "영국 (United Kingdom)", "프랑스 (France)", "독일 (Germany)", "일본 (Japan)", "중국 (China)", "한국 (Republic of Korea)", "인도 (India)", "브라질 (Brazil)", "멕시코 (Mexico)", "호주 (Australia)", "러시아 (Russia)", "남아프리카 공화국 (South Africa)", "이탈리아 (Italy)", "스페인 (Spain)", "네덜란드 (Netherlands)", "스웨덴 (Sweden)", "노르웨이 (Norway)", "핀란드 (Finland)"};

    String[] names = {"Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella", "Oliver", "Charlotte", "Benjamin", "Amelia", "Elijah", "Mia", "Lucas", "Harper", "Mason", "Evelyn", "Logan", "Abigail", "Alexander", "Emily", "Ethan", "Elizabeth", "Henry", "Avery", "Jackson", "Sofia", "Sebastian", "Michael", "Avery", "Madison", "Jack", "Aria", "Evan", "Scarlett", "Ryan", "Grace", "David", "Chloe", "Nathan", "Zoey", "Daniel", "Lily", "Nicholas", "Addison", "John", "Natalie", "Christopher", "Hannah"};

    private static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startDay, endDay + 1);
        return LocalDate.ofEpochDay(randomDay);
    }

    private Nation createNation() {
        return new Nation(nations[new Random().nextInt(nations.length)]);
    }

    private Author createAuthor() {
        return new Author(
                names[new Random().nextInt(names.length)],
                generateRandomDate(
                        LocalDate.of(1950, 1, 1),
                        LocalDate.of(1990, 12, 12)
                ),
                createNation(),
                "ToDO");
    }

    protected List<Author> createAuthors() {
        List<Author> authors = new ArrayList<>();
        IntStream.rangeClosed(1, 3)
                .forEach(i -> authors.add(createAuthor()));
        return authors;
    }

    protected DateInfo createDateInfo() {
        return new DateInfo(
                generateRandomDate(
                        LocalDate.of(2010, 1, 1),
                        LocalDate.now()
                )
        );
    }

}
