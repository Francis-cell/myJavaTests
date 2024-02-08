package com.zmr.LearningFiles.EffectiveJavaDemos.ThreadDemos;



import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSet<E> extends ForwardingSet<E> {
    // public ObservableSet(Set<E> set) {
    //     super(set);
    // }
    //
    // private final List<SetObserver<E>> observers = new ArrayList<>();
    //
    // public void addObserver(SetObserver<E> observer) {
    //     synchronized (observers) {
    //         observers.add(observer);
    //     }
    // }
    //
    // public boolean removeObserver(SetObserver<E> observer) {
    //     synchronized (observers) {
    //         return observers.remove(observer);
    //     }
    // }
    //
    // public void notifyElementAdded(E element) {
    //     // // 非快照写法
    //     // synchronized (observers) {
    //     //     for (SetObserver<E> observer : observers) {
    //     //         observer.added(this, element);
    //     //     }
    //     // }
    //
    //     // 将外来方法移出同步代码块
    //     List<SetObserver<E>> snapshot = null;
    //     synchronized (observers) {
    //         snapshot = new ArrayList<>(observers);
    //     }
    //     for (SetObserver<E> observer : snapshot) {
    //         observer.added(this, element);
    //     }
    // }
    //
    // @Override
    // public boolean add(E element) {
    //     boolean added = super.add(element);
    //     if (added) {
    //         notifyElementAdded(element);
    //     }
    //     return added;
    // }
    //
    // public boolean addAll(Collection<? extends E> c) {
    //     boolean result = false;
    //     for (E element : c) {
    //         result |= add(element);
    //     }
    //     return result;
    // }










    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
    }

    public void notifyElementAdded(E element) {
        for (SetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element);
        }
        return result;
    }
}
