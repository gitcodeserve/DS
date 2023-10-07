package com.learning.ds.string;

import java.util.Stack;

public class ParenthesisMatch {

    public
    static boolean balancedParenthesis(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                //after pushing continue with next character
                continue;
            }
            //After pushing if stack is empty which means no parenthesis
            if (stack.isEmpty()) return false;
            //In this iteration check for closing bracket.
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[') return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[') return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{') return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
    public
    static void main(String[] args) {
        String str = "(Hi My Name is)[({(Shantanu sa{h}y)})]";
        if (balancedParenthesis(str))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
