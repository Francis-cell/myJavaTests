package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.ThreadDemos;

@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
