package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.CompositionAndInheritance;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> {
    private Vector<E> data = new Vector<E>();

    public void push(E item) {
        data.addElement(item);
    }

    /**
     * 同时将多个元素按照顺序压入栈中
     * @param items
     */
    public void multiPush(E... items) {
        for (E item : items) {
            push(item);
        }
    }

    public E pop() {
        E item = peek();
        data.removeElementAt(size() -1);
        return item;
    }

    public E peek() {
        int size = data.size();
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data.elementAt(size - 1);
    }

    public int size() {
        return data.size();
    }

    // ...
}
