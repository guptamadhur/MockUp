package com.guptamadhur.Interview.LinkedList;

/*
        # Author: Madhur Gupta
        # Github: github.com/guptamadhur
        # Project: Java MockUp

        Java program to revered a LinkedList
*/

public class Reverse {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    Node reverse(Node node){
        Node current=node, prev=null, next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        node=prev;
        return node;
    }
    void printList(Node node){
       while(node!=null){
           System.out.print(node.data+"-->");
           node=node.next;
       }
    }

    public static void main(String[] args) {
        Reverse list=new Reverse();
        list.head = new Node(57);
        list.head.next = new Node(85);
        list.head.next.next = new Node(20);
        list.head.next.next.next = new Node(45);

        System.out.println("Actual List");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("\nReversed List");
        list.printList(head);
    }
}
