package com.xyz0751.learn.leetcode.stack;

import javafx.collections.transformation.SortedList;

import java.util.*;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer pop = dataStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
//        ms.push(3);
        System.out.println(ms.getMin());
        ms.pop();;
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
