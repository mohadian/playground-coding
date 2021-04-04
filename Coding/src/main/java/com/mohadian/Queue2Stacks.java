package com.mohadian;

import java.util.Stack;

class Queue2Stacks<T> {
    Stack<T> headStack = new Stack<>();
    Stack<T> tailStack = new Stack<>();

    public void enqueue(T item) {
        tailStack.push(item);
    }

    public T dequeue() {
        if (!headStack.isEmpty()) {
            return headStack.pop();
        } else if (!tailStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
            return headStack.pop();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return headStack.isEmpty() && tailStack.isEmpty();
    }
}
