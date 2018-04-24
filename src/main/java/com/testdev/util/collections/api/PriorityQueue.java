package com.testdev.util.collections.api;

import com.testdev.util.model.Priority;

public interface PriorityQueue<E extends Priority> {

    int add(E e);

    E get();

    boolean edit(E e);

    int size();

}
