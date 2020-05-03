package web.app.madhurgupta.JavaPractice.Others;

import java.util.*;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
# Java program to demonstrate working of Comparator interface more than one field
 */

class StudentDetail {

    // instance member variables
    String Name;
    int Age;

    // parameterized constructor
    public StudentDetail(String Name, Integer Age) {
        this.Name = Name;
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer Age) {
        this.Age = Age;
    }

    // overriding toString() method
    @Override
    public String toString() {
        return "Customer{" + "Name=" + Name + ", Age=" + Age + '}';
    }

    static class CustomerSortingComparator implements Comparator<StudentDetail> {

        @Override
        public int compare(StudentDetail customer1, StudentDetail customer2) {
            // for comparison
            int NameCompare = customer1.getName().compareTo(customer2.getName());
            int AgeCompare = customer1.getAge().compareTo(customer2.getAge());

            // 2-level comparison using if-else block
            if (NameCompare == 0) {
                return ((AgeCompare == 0) ? NameCompare : AgeCompare);
            } else {
                return NameCompare;
            }
        }
    }

    public static void main(String[] args) {

        // create ArrayList to store StudentDetail
        List<StudentDetail> al = new ArrayList<>();

        // create customer objects using constructor initialization
        StudentDetail obj1 = new StudentDetail("Ajay", 27);
        StudentDetail obj2 = new StudentDetail("Sneha", 23);
        StudentDetail obj3 = new StudentDetail("Simran", 37);
        StudentDetail obj4 = new StudentDetail("Ajay", 22);
        StudentDetail obj5 = new StudentDetail("Ajay", 29);
        StudentDetail obj6 = new StudentDetail("Sneha", 22);

        // add customer objects to ArrayList
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);

        // before Sorting arraylist: iterate using Iterator
        Iterator<StudentDetail> custIterator = al.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator);
        Collections.sort(al, new CustomerSortingComparator());

        // after Sorting arraylist: iterate using enhanced for-loop
        System.out.println("\n\nAfter Sorting:\n");
        for (StudentDetail customer : al) {
            System.out.println(customer);
        }
    }
}