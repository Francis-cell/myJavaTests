package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.CompositionAndInheritance;

public class CountingStackWithInheritance<E> {
    private Stack<E> stack = new Stack<E>();

    private int pushCount;

    public void push(E item) {
        ++pushCount;
        stack.push(item);
    }

    public void multiPush(E... items) {
        pushCount += items.length;
        stack.multiPush(items);
    }

    public E pop() {
        return stack.pop();
    }

    public E peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public int getPushCount() {
        return pushCount;
    }
}
