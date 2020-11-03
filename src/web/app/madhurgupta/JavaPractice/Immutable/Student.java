package web.app.madhurgupta.JavaPractice.Immutable;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode Java
# Created on: 03-11-2020 09:04
*/

/*

 */
public final class Student {
    private final int id;
    private final String name;
    private final Age age;

    public Student(int id, String name, Age age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

}
