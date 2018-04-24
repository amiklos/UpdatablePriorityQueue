package com.testdev.util.collections.impl;

import com.testdev.util.collections.api.PriorityQueue;
import com.testdev.util.model.Priority;

public class SynchronizedPriorityQueue<E extends Priority> implements PriorityQueue<E> {
    private static final int DEFAULT_SIZE = 40;

    private int capacity;
    private int size;
    private Object[] elements;
    private Object mutex;

    public SynchronizedPriorityQueue() {
        this.capacity = DEFAULT_SIZE;
        this.elements = new Object[this.capacity];
        this.mutex = new Object();
    }

    public SynchronizedPriorityQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be a negativ number");
        }
        this.capacity = initialCapacity;
        this.elements = new Object[this.capacity];
        this.mutex = new Object();
    }

    public int add(E e) {
        synchronized (mutex) {
            if (this.size >= this.capacity) {
                throw new IllegalStateException("Capacity exceeded");
            }
            this.elements[this.size++] = e;
            if (this.size != 0) {
                sort();
            }
            return this.size;
        }
    }

    public E get() {
        synchronized (mutex) {
            if (this.size > 0) {
                return (E) this.elements[this.size - 1];
            }
            return null;
        }
    }

    public boolean edit(E e) {
        synchronized (mutex) {
            int i = 0;
            boolean notFound = true;
            while (i < this.size && notFound) {
                E element = (E) this.elements[i];
                if (element.equals(e)) {
                    this.elements[i] = e;
                    notFound = false;
                }
                i++;
            }
            if (!notFound) {
                sort();
            }
            return notFound;
        }
    }

    public int size() {
        synchronized (mutex) {
            return this.size;
        }
    }

    private void sort() {
        int n = this.size;
        int i = 0;
        boolean swapNeeded = true;
        while (i < n - 1 && swapNeeded) {
            swapNeeded = false;
            for (int j = 1; j < n - i; j++) {
                Comparable c1 = (Comparable) this.elements[j - 1];
                Comparable c2 = (Comparable) this.elements[j];
                if (c1.compareTo(c2) < 0) {
                    changeElements(j - 1, j);
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) {
                break;
            }
            i++;
        }
    }

    private void changeElements(int i, int j) {
        Object aux = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = aux;
    }

}


