package com.company;


class Stack<Type> {

    private Node<Type> head = null;

    void push(Type value) {
        Node<Type> element = new Node<>(value);
        element.next = head;
        head = element;
    }

    Type pop() {
        Type value = head.value;
        head = head.next;
        return value;
    }

    Type peek() {
        return head.value;
    }

    void printStack() {
        Node<Type> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    boolean isStackEmpty() {
        return head == null;
    }
}
