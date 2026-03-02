package stream;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {

        List<Student1> students = List.of(
                new Student1("John",56,17),
                new Student1("Jack",60,19),
                new Student1("Ashmit",45,18),
                new Student1("Arnab",80,17)
        );

        // filter + peek + map + sorted + toList
        List<Student1> passed = students.stream()
                .filter(s -> s.marks > 50)
                .peek(s -> System.out.println("Passed: " + s.name))
                .map(s -> new Student1(s.name, s.marks * 2, s.age))
                .sorted(Comparator.comparingInt(s -> s.marks))
                .toList();

        System.out.println("\nPassed Students After Modification:");
        System.out.println(passed);

        // anyMatch()
        boolean hasTopper = students.stream()
                .anyMatch(s -> s.marks > 75);

        System.out.println("\nAny student with marks > 75? " + hasTopper);

        // findFirst()
        Optional<Student1> firstPassed = students.stream()
                .filter(s -> s.marks > 50)
                .findFirst();

        firstPassed.ifPresent(s -> 
                System.out.println("\nFirst Passed Student: " + s));
    }
}

class Student1{
    String name;
    int marks;
    int age;

    Student1(String name, int marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name +
                "', marks=" + marks +
                ", age=" + age + "}";
    }
}