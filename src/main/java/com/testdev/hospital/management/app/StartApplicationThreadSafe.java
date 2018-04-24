package com.testdev.hospital.management.app;

import com.testdev.hospital.management.model.Accident;
import com.testdev.util.collections.impl.SynchronizedPriorityQueue;

public class StartApplicationThreadSafe {

    public static void main(String[] args) {
        final SynchronizedPriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident brokenLeg = new Accident("Broken leg");
        brokenLeg.setPriority(1);
        Accident paperCut = new Accident("Paper cut");
        paperCut.setPriority(3);
        Accident brokenArm = new Accident("Broken arm");
        brokenArm.setPriority(2);
        final Accident brokenElbow = new Accident("Broken elbow");
        brokenElbow.setPriority(4);
        final Accident brokenHead = new Accident("Broken head");
        brokenHead.setPriority(5);
        accidentPriorityQueue.add(brokenLeg);
        accidentPriorityQueue.add(paperCut);
        accidentPriorityQueue.add(brokenArm);
        final Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 1: " + accidentPriorityQueue.add(brokenElbow));
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 2: " + accidentPriorityQueue.add(brokenHead));
            }
        });
        thread1.start();
        thread2.start();
    }
}

