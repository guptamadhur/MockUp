package web.app.madhurgupta.JavaPractice.Comparable;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode Java
# Created on: 03-11-2020 09:50
*/

import java.util.ArrayList;
import java.util.Collections;

/*

 */

public class ComparableExample {
    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(200, "Alex", "Mumbai"));
        ar.add(new Student(121, "cccc", "jaipur"));
        ar.add(new Student(111, "bbb", "London"));
        ar.add(new Student(112, "asa", "France"));

        display(ar, "Unsorted");
        Collections.sort(ar);
        display(ar, "Sorted by ID");
    }

    private static void display(ArrayList<Student> ar, String message) {
        System.out.println("\n" + message);
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String address;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public int compareTo(Student stu) {
        return (this.id - stu.id);
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.address;
    }
}

