package com.company;

import java.util.Scanner;

public class Main {

    static String expressionToRPN(String expression) {
        Stack<Character> stackTemp = new Stack<>();
        String current = "";
        for (int i = 0; i < expression.length(); i++) {
            if (getPriority(expression.charAt(i)) >= 2) {
                if (stackTemp.isStackEmpty()) {
                    stackTemp.push(expression.charAt(i));
                } else {
                    while (!stackTemp.isStackEmpty() && getPriority(stackTemp.peek()) > getPriority(expression.charAt(i))) {
                        current += stackTemp.pop();
                    }
                    stackTemp.push(expression.charAt(i));
                }
            } else if (getPriority(expression.charAt(i)) == 1) {
                stackTemp.push(expression.charAt(i));
            } else if (getPriority(expression.charAt(i)) == -1) {
                while (getPriority(stackTemp.peek()) != 1) {
                    current += stackTemp.pop();
                }
                stackTemp.pop();
            } else {
                current += expression.charAt(i);
            }
            if (i == expression.length() - 1 && !stackTemp.isStackEmpty()) {
                while (!stackTemp.isStackEmpty()) {
                    current += stackTemp.pop();
                }
            }
        }
        return current;
    }

    static String expressionToPN(String expression) {
        StringBuffer reverseExp = new StringBuffer(expression);
        reverseExp.reverse();
        for (int i = 0; i < reverseExp.length(); i++) {
            if (reverseExp.charAt(i) == '(') {
                reverseExp.setCharAt(i, ')');
            } else if (reverseExp.charAt(i) == ')') {
                reverseExp.setCharAt(i, '(');
            }
        }
        String current = new String(reverseExp);
        current = expressionToRPN(current);
        reverseExp = new StringBuffer(current);
        reverseExp.reverse();
        current = new String(reverseExp);
        return current;
    }

    static byte getPriority(char element) {
        byte priority;
        if (element == '^') {
            priority = 4;
        } else if (element == '*' || element == '/') {
            priority = 3;
        } else if (element == '+' || element == '-') {
            priority = 2;
        } else if (element == '(') {
            priority = 1;
        } else if (element == ')') {
            priority = -1;
        } else {
            priority = 0;
        }
        return priority;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в инфиксной форме записи: ");
        String expression;
        expression = scanner.nextLine();
        System.out.println("Выражение в инфиксной форме записи: " + expression);
        System.out.println("Выражение в польской нотации: " + expressionToPN(expression));
        System.out.println("Выражение в обратной польской нотации: " + expressionToRPN(expression));
    }
}

