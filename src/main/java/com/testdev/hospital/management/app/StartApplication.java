package com.testdev.hospital.management.app;

import com.testdev.hospital.management.builder.AccidentBuilder;
import com.testdev.hospital.management.model.Accident;
import com.testdev.util.collections.api.PriorityQueue;
import com.testdev.util.collections.impl.SynchronizedPriorityQueue;
import java.time.LocalDate;

public class StartApplication {

    public static void main(String[] args) {
        final PriorityQueue<Accident> accidentPriorityQueue = new SynchronizedPriorityQueue();
        Accident brokenLeg = new AccidentBuilder().setFirstName("Maria").setLastName("Smith").setDescription("Broke leg").setCountry("UK").setCountry("Mancester").setArrival(LocalDate.now()).build();
        brokenLeg.setPriority(2);
        Accident paperCut = new AccidentBuilder().setFirstName("John").setLastName("Smith").setDescription("Paper cut").setCountry("UK").setCountry("Mancester").setArrival(LocalDate.now()).build();
        paperCut.setPriority(4);
        Accident brokenArm = new AccidentBuilder().setFirstName("John").setLastName("Doe").setDescription("Broken arm").setCountry("UK").setCountry("Mancester").setArrival(LocalDate.now()).build();
        brokenArm.setPriority(3);
        accidentPriorityQueue.add(brokenLeg);
        accidentPriorityQueue.add(paperCut);
        accidentPriorityQueue.add(brokenArm);
        System.out.println(accidentPriorityQueue.get());
        paperCut.setPriority(1);
        accidentPriorityQueue.edit(paperCut);
        System.out.println(accidentPriorityQueue.get());
    }
}
