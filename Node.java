package com.company;

class Node<Type> {
    Node<Type> next;
    Type value;

    Node(Type value) {
        this.value = value;
    }
}
