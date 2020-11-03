package web.app.madhurgupta.JavaPractice.Immutable;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode Java
# Created on: 03-11-2020 09:08
*/

/*

 */
public class ImmutableStudent {
    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(2);
        age.setYear(2020);
        Student student = new Student(1, "Alex", age);
        System.out.println("Student:" + student.getName() + " " + student.getAge().getYear());
        student.getAge().setYear(1990);
        System.out.println("Student:" + student.getName() + " " + student.getAge().getYear());
    }
}
