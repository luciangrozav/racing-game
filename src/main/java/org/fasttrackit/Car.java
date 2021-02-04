package org.fasttrackit;

// "is-a" relantionship (inheritance)

public class Car extends AutoVehicle {  // relatia de mostenire; clasa AutoVehicle este clasa parinte a lui Car

    int doorCount;

    public Car(Engine engine) {  // oriunde in App.java va fi obligatoriu sa existe un engine, astfel constructorul trebuie apelat la fiecare new (); de tip Car si AutoVehicle
        super(engine);
    }


    // "has-a" relationship (aggregation)



}
