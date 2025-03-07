package com.zmr.LearningFiles.BooksReading.BubbleLessons.Plural.CompositionAndInheritance;

public class CountingStackWithComposition<E> extends Stack<E>{
    // 压栈总次数
    private int pushCount;

    @Override
    public void push(E item) {
        ++pushCount;
        super.push(item);
    }

    // @Override
    // public void multiPush(E... items) {
    //     pushCount += items.length;
    //     super.multiPush(items);
    // }

    public int getPushCount() {
        return pushCount;
    }
}
