package com.example.demo.entity;

import com.example.demo.apple.entity.Apple;
import com.example.demo.apple.entity.vo.AppleSpec;
import com.example.demo.apple.entity.vo.Color;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.example.demo.apple.entity.vo.Color.*;


class AppleTest {

    private static Map<String, Function<AppleSpec, Apple>> appleFactory = new HashMap<>();
    private static List<Apple> apples;

    private static Color[] colors = {RED, GREEN, BLUE, YELLOW};
    private static float[] floats = {10.5f, 20.0f, 30.5f, 40.0f};
    private ObjectMapper objectMapper = new ObjectMapper();

    private static Apple createAppleHelper() {
        AppleSpec appleSpec = createAppleSpecHelper();
        return new Apple(appleSpec);
    }

    private static AppleSpec createAppleSpecHelper() {
        int color = new Random().nextInt(colors.length - 1);
        int size = new Random().nextInt(floats.length - 1);
        int price = new Random().nextInt(floats.length - 1);
        int weight = new Random().nextInt(floats.length - 1);
        return new AppleSpec(colors[color], floats[size], floats[price], floats[weight]);
    }

    @BeforeEach
    void setup() {
        appleFactory = new HashMap<>();
        apples = new ArrayList<>();
    }

    @AfterEach
    void clear() {
        appleFactory.clear();
        apples.clear();
    }

    @Test
    void lambda_Comparator() {
        AppleSpec redAppleSpec = new AppleSpec(RED, 10.0f, 1.0f, 0.5f);
        AppleSpec greenAppleSpec = new AppleSpec(GREEN, 15.0f, 1.5f, 1.5f);
        Apple redApple = new Apple(redAppleSpec);
        Apple greenApple = new Apple(greenAppleSpec);
    }   //  sorting 할때 사용, 비교 기준이 되는 객체가 크면1 같으면0 작으면 -1 반환


    @Test
    void sort_Comparator() throws Exception {
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            apples.add(createAppleHelper());
        }
        apples.sort(Comparator.comparing(Apple::getSpec));
    }

    @Test
    void appleCreator_Function() {
        appleFactory.put("A1", Apple::new);
        Apple a1 = appleFactory.get("A1").apply(createAppleSpecHelper());
        System.out.println(a1);
    }

    @Test
    void stream_test() {
        for (int i = 0; i < 5000; i++) {
            apples.add(createAppleHelper());
        }
        List<Apple> list = apples.parallelStream()
                .filter(item -> item.getSpec().getColor() == RED)
                .toList();
        System.out.println(list);
    }

    @Test
    void consume_test1() {
        List<String> strList = List.of("JAVA", "8", "IN", "ACTION");
        Stream<String> s = strList.stream();
        s.forEach(System.out::println);
        Assertions.assertThrows(IllegalStateException.class, () ->
                s.forEach(System.out::println)
        );
    }   //  stream 은 한번 사용하면 사라진다.


    @Test
    void consume_test2() {
        for (int i = 0; i < 50; i++) {
            apples.add(createAppleHelper());
        }
        List<Apple> list = apples.stream()
                .filter(item -> item.getSpec().getColor() == RED)
                .distinct()
                .limit(3)
                .toList();
        Assertions.assertEquals(list.size(), 3);
    }   //  stream 은 한번 사용하면 사라진다.

    @Test
    void mapping() {

        List<String> strList = List.of("Hello", "World");

        List<String> list = strList.stream()
                .map(item -> item.split(""))
                .flatMap(Arrays::stream)
                .toList();

        System.out.println(list);

    }

    @Test
    void optional() {
        for (int i = 0; i < 50; i++) {
            apples.add(createAppleHelper());
        }
        apples.stream()
                .filter(item -> item.getSpec().getColor() == RED)
                .findAny()
                .ifPresent(item -> System.out.println(item.getSpec()));
    }

    @Test
    void reduce() {

        for (int i = 0; i < 50; i++) {
            apples.add(createAppleHelper());
        }

        Float reduce = apples.stream()
                .map(Apple::getSpec)
                .map(AppleSpec::getPrice)
                .reduce(0.0f, Float::sum);

        System.out.println(reduce);

    }

    @Test
    void integerStream() {

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)}
                                )
                );

        pythagoreanTriples.forEach(numbers ->
                System.out.println(numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + ((numbers[0] * numbers[0]) + (numbers[1] * numbers[1]) == numbers[2] * numbers[2]))
        );

    }


    @Test
    void optionalNullableTest() {

        Apple apple = null;
        Optional<Apple> optionalApple = Optional.ofNullable(apple);

        Assertions.assertEquals(Optional.empty(), optionalApple);

        Apple supplierApple = optionalApple
                .orElseGet(AppleTest::createAppleHelper);

        Assertions.assertNotNull(supplierApple);
        System.out.println(supplierApple);

    }

}
