package web.app.madhurgupta.JavaPractice.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

class Student {
    int rollno;
    String name, address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.rollno + " " + this.name + " " + this.address;
    }
}

class SortByRoll implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

class SortByName implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbb", "London"));
        ar.add(new Student(112, "asa", "France"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new SortByRoll());

        System.out.println("\nSorted by rollno");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new SortByName());

        System.out.println("\nSorted by name");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}
