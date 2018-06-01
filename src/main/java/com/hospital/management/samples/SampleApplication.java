package com.hospital.management.samples;

import com.devtest.util.collections.api.UpdatablePriorityQueue;
import com.devtest.util.collections.impl.SynchronizedUpdatablePriorityQueue;
import java.util.Comparator;

public class SampleApplication {

    public static void main(String[] args) {
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        UpdatablePriorityQueue accidentManagementQueue = new SynchronizedUpdatablePriorityQueue(integerComparator);
        accidentManagementQueue.insertElementWithPriority(4, "Broken shoulder");
        accidentManagementQueue.insertElementWithPriority(3, "Broken leg");
        accidentManagementQueue.insertElementWithPriority(2, "Broken arm");
        accidentManagementQueue.insertElementWithPriority(1, "Broken head");
        System.out.println(accidentManagementQueue.getElementWithHighestPriority());
    }
}
