package com.epam.jmp.streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aleksei_Okhrimenko on 30.06.2017.
 */
public class Example {
    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                new Person("Mike", 30),
                new Person("Jeremy", 35),
                new Person("Ben", 40)
        );

        Person result1 = list.stream()
                .filter(x -> "Jeremy".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result1);

        Person result2 = list.stream()
                .filter(x -> "Andy".equals(x.getName()))
                .findAny()
                .orElse(null);

        System.out.println(result2);

        Person result3 = list.stream()
                .filter((p) -> "Mike".equals(p.getName()) && 30 == p.getAge())
                .findAny()
                .orElse(null);

        System.out.println(result3);
    }
}
