package web.app.madhurgupta.Helper.Node;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: MockUp
# Created on: 19-05-2020 01:45
*/

public class SingleNode {
    private Double value;
    private SingleNode next;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }
}
