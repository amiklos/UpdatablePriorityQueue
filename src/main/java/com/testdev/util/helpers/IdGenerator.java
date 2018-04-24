package com.testdev.util.helpers;

public class IdGenerator {
    private static IdGenerator instance;
    private int id = 0;

    private IdGenerator() {
    }

    public static IdGenerator getInstace() {
        synchronized (IdGenerator.class) {
            if (instance == null) {
                instance = new IdGenerator();
            }
            return instance;
        }
    }

    public int getId() {
        return ++id;
    }


}
