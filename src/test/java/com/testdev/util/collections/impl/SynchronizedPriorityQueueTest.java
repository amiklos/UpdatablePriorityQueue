package com.testdev.util.collections.impl;

import com.testdev.hospital.management.builder.AccidentBuilder;
import com.testdev.hospital.management.model.Accident;
import com.testdev.util.collections.api.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SynchronizedPriorityQueueTest {

    @Test
    public void addFirstElement() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident accident = new AccidentBuilder().setDescription("Gunshot wound").build();
        accident.setPriority(1);
        int size = accidentPriorityQueue.add(accident);
        Assertions.assertEquals(1, size);
        Assertions.assertEquals(accident, accidentPriorityQueue.get());
    }

    @Test
    public void addAndSort() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident accident1 = new AccidentBuilder().setDescription("Gunshot wound").build();
        ;
        accident1.setPriority(2);
        Accident accident2 = new AccidentBuilder().setDescription("Broken leg").build();
        accident2.setPriority(1);
        Accident accident3 = new AccidentBuilder().setDescription("Broken arm").build();
        accident3.setPriority(3);
        accidentPriorityQueue.add(accident1);
        accidentPriorityQueue.add(accident2);
        int size = accidentPriorityQueue.add(accident3);
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(accident2, accidentPriorityQueue.get());
    }

    @Test
    public void addSamePriority() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident accident1 = new AccidentBuilder().setDescription("Gunshot wound").build();
        accident1.setPriority(1);
        Accident accident2 = new AccidentBuilder().setDescription("Broken leg").build();
        accident2.setPriority(1);
        Accident accident3 = new AccidentBuilder().setDescription("Broken arm").build();
        accident3.setPriority(1);
        accidentPriorityQueue.add(accident1);
        accidentPriorityQueue.add(accident2);
        int size = accidentPriorityQueue.add(accident3);
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(accident3, accidentPriorityQueue.get());
    }

    @Test
    public void addExceedingCapacity() {
        final PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue(1);
        Accident accident1 = new AccidentBuilder().setDescription("Gunshot wound").build();
        accident1.setPriority(1);
        final Accident accident2 = new AccidentBuilder().setDescription("Broken arm").build();
        accident2.setPriority(1);
        accidentPriorityQueue.add(accident1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            accidentPriorityQueue.add(accident2);
        });
    }

    @Test
    public void getFromEmpty() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        accidentPriorityQueue.get();
    }

    @Test
    public void editSuccessfully() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident accident1 = new AccidentBuilder().setDescription("Gunshot wound").build();
        accident1.setPriority(1);
        Accident accident2 = new AccidentBuilder().setDescription("Broken leg").build();
        accident2.setPriority(1);
        Accident accident3 = new AccidentBuilder().setDescription("Broken arm").build();
        accident3.setPriority(1);
        accidentPriorityQueue.add(accident1);
        accidentPriorityQueue.add(accident2);
        int size = accidentPriorityQueue.add(accident3);
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(accident3, accidentPriorityQueue.get());
        accident1.setPriority(-1);
        accidentPriorityQueue.edit(accident1);
        Assertions.assertEquals(accident1, accidentPriorityQueue.get());
    }

    @Test
    public void editNotFound() {
        PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident accident1 = new AccidentBuilder().setDescription("Gunshot wound").build();
        accident1.setPriority(1);
        Accident accident2 = new AccidentBuilder().setDescription("Broken leg").build();
        accident2.setPriority(2);
        Accident accident3 = new AccidentBuilder().setDescription("Broken arm").build();
        accident3.setPriority(3);
        Accident accident4 = new AccidentBuilder().setDescription("Knee injuries").build();
        accident4.setPriority(4);
        accidentPriorityQueue.add(accident1);
        accidentPriorityQueue.add(accident2);
        int size = accidentPriorityQueue.add(accident3);
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(accident1, accidentPriorityQueue.get());
        accident4.setPriority(0);
        accidentPriorityQueue.edit(accident1);
        Assertions.assertEquals(accident1, accidentPriorityQueue.get());
    }

}
