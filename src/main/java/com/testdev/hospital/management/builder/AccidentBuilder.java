package com.testdev.hospital.management.builder;

import com.testdev.hospital.management.model.Accident;
import java.time.LocalDate;

public class AccidentBuilder {
    private Accident accident;

    public AccidentBuilder() {
        this.accident = new Accident();
    }

    public AccidentBuilder setFirstName(String firstName) {
        this.accident.setFirstName(firstName);
        return this;
    }

    public AccidentBuilder setLastName(String lastName) {
        this.accident.setLastName(lastName);
        return this;
    }

    public AccidentBuilder setCountry(String country) {
        this.accident.getAddress().setCountry(country);
        return this;
    }

    public AccidentBuilder setCity(String city) {
        this.accident.getAddress().setCity(city);
        return this;
    }

    public AccidentBuilder setStreet(String street) {
        this.accident.getAddress().setStreet(street);
        return this;
    }

    public AccidentBuilder setNumber(String number) {
        this.accident.getAddress().setNumber(number);
        return this;
    }

    public AccidentBuilder setDescription(String description) {
        this.accident.setDescription(description);
        return this;
    }

    public AccidentBuilder setArrival(LocalDate date) {
        this.accident.setArrival(date);
        return this;
    }

    public Accident build() {
        return accident;
    }
}
