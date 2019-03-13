package com.mohadian;

import java.util.Stack;

class StackWithMaxOperator {

    Stack<Item> stack = new Stack<>();

    public void push(int val) {
        Item toPush = new Item(val);
        if (!stack.isEmpty()) {
            Item top = stack.peek();
            if (top.max.item > val) {
                toPush.max = top.max;
            }
        }
        stack.push(toPush);
    }

    public int pop() {
        return stack.pop().item;
    }

    public int max() {
        return stack.peek().max.item;
    }

    class Item {
        Integer item;
        Item max;

        public Item(Integer item) {
            this.item = item;
            max = this;
        }
    }
}
