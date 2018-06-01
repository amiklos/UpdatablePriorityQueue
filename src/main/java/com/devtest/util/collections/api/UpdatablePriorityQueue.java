package com.devtest.util.collections.api;

import com.devtest.util.collections.impl.Element;

/**
 * Priority queue which allows to change the priority of an element after insertion.
 */
public interface UpdatablePriorityQueue {

    /**
     * Insert the given object into the priority queue, allowing duplicate priorities.
     *
     * @param priority - the priority of the object
     * @param data     - value
     * @return Element - the inserted element including priority, value and position
     */
    Element insertElementWithPriority(Object priority, Object data);

    /**
     * Retrieves the object with the highest priority.
     *
     * @return Element - the element with the highest priority, null if the queue is empty
     */
    Element getElementWithHighestPriority();

    /**
     * Change the current priority of the element with the new priority specified.
     * If the element does not exist no changes will be performed.
     *
     * @param element     - the element to be updated
     * @param newPriority - new priority of the element
     */
    void changeElementPriority(Element element, Object newPriority);

    /**
     * Removes the element with the highest priority.
     *
     * @return Element - the element with the highest priority (position of the removed element will become -1),
     * null if the queue is empty
     */
    Element removeElementWithHighestPriority();

}
