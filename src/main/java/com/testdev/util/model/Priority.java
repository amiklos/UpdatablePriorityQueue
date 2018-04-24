package com.testdev.util.model;

import com.testdev.hospital.management.model.Accident;
import com.testdev.util.helpers.IdGenerator;
import java.util.UUID;

public abstract class Priority implements Comparable {
    private int id;
    private int priority;

    public Priority() {
        this.id = IdGenerator.getInstace().getId();
    }

    public Priority(int priority) {
        this.id = IdGenerator.getInstace().getId();
        UUID.randomUUID();
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "" + this.priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Accident) {
            Accident accident = (Accident) obj;
            return this.id == accident.getId();
        }
        return false;
    }

    public int compareTo(Object o) {
        if (!(o instanceof Priority)) {
            throw new ClassCastException("Parameter is not Priority type");
        }
        Priority priority = (Priority) o;
        if (this.priority == priority.getPriority()) {
            return 0;
        } else if (this.priority < priority.getPriority()) {
            return -1;
        } else {
            return 1;
        }
    }
}
