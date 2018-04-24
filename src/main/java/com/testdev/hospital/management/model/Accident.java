package com.testdev.hospital.management.model;

import com.testdev.util.model.Priority;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Accident extends Priority {
    private String firstName;
    private String lastName;
    private Address address;
    private String description;
    private LocalDate arrival;

    public Accident() {
        this.address = new Address();
        this.arrival = LocalDate.now();
    }

    public Accident(String description) {
        this.description = description;
        this.address = new Address();
        this.arrival = LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        String arrivalToString = this.arrival != null ? this.arrival.format(DateTimeFormatter.ISO_DATE) : "";
        return "[" + this.firstName + ", " + this.lastName + ", " + this.address + ", " + this.description + ", " + arrivalToString + "]";
    }
}
