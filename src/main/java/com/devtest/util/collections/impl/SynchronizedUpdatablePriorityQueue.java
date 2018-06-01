package com.devtest.util.collections.impl;

import com.devtest.util.collections.api.UpdatablePriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Syncronized updatable heap-based priority queue with user-defined order of elements.
 */
public class SynchronizedUpdatablePriorityQueue implements UpdatablePriorityQueue {
    private static int DEFAULT_CAPACITY = 10;
    private Comparator comparator;
    private Element[] elements;
    private int size;

    public SynchronizedUpdatablePriorityQueue(Comparator comparator) {
        this.elements = new Element[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    /**
     * {@inheritDoc}
     * Complexity : O(log n)
     */
    @Override
    public synchronized Element insertElementWithPriority(Object priority, Object data) {
        ensureCapacity(this.size + 1);
        Element e = new Element(priority, data, this.size + 1);
        if (this.size == 0) {
            this.elements[1] = e;
            this.size = 1;
        } else {
            this.elements[this.size + 1] = e;
            this.size = this.size + 1;
            bubbleUp(e);
        }
        return e;
    }

    /**
     * {@inheritDoc}
     * Complexity : O(1)
     */
    @Override
    public synchronized Element getElementWithHighestPriority() {
        return this.elements[1];
    }

    /**
     * {@inheritDoc}
     * Complexity : O(log n)
     */
    @Override
    public synchronized void changeElementPriority(Element e, Object newPriority) {
        if (comparator.compare(newPriority, e.getPriority()) < 0) {
            e.setPriority(newPriority);
            bubbleUp(e);
        } else {
            e.setPriority(newPriority);
            bubbleDown(e);
        }

    }

    /**
     * {@inheritDoc}
     * Complexity : O(log n)
     */
    @Override
    public synchronized Element removeElementWithHighestPriority() {
        Element min = this.elements[1];
        if (this.size == 0) {
            return null;
        }
        min.setPos(-1);
        if (this.size == 1) {
            this.elements[1] = null;
        } else {
            this.elements[1] = this.elements[this.size];
            this.elements[1].setPos(1);
            this.elements[this.size] = null;
            if (this.size == 2) {
                this.size = 1;
            } else {
                this.size--;
                bubbleDown(this.elements[1]);
            }
        }
        return min;
    }

    private void ensureCapacity(int i) {
        if (i >= this.elements.length) {
            int newCapacity = this.elements.length + DEFAULT_CAPACITY / 2;
            this.elements = Arrays.copyOf(this.elements, newCapacity);
        }
    }

    private void bubbleUp(Element e) {
        int i = e.getPos();
        int parent;
        do {
            parent = parent(i);
            if (parent >= 1 && (this.comparator.compare(this.elements[i].getPriority(), this.elements[parent].getPriority())) < 0) {
                swap(i, parent);
                i = parent;
            }
        } while (i == parent && parent >= 1);
    }

    private void bubbleDown(Element e) {
        int min = e.getPos();
        int i;
        do {
            i = min;
            int l = leftChild(i);
            int r = rightChild(i);
            if (l <= this.size) {
                if (this.comparator.compare(this.elements[l].getPriority(), this.elements[i].getPriority()) < 0) {
                    min = l;
                }
                if (this.elements[r] != null && this.comparator.compare(this.elements[r].getPriority(), this.elements[min].getPriority()) < 0) {
                    min = r;
                }
                if (i != min) {
                    swap(i, min);
                }
            }
        } while (i != min);
    }

    private int parent(int i) {
        return i / 2;
    }

    private int rightChild(int i) {
        return 2 * i;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        Element temp = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = temp;
        this.elements[i].setPos(i);
        this.elements[j].setPos(j);
    }

}
