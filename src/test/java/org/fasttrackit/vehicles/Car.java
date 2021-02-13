package org.fasttrackit.vehicles;

// "is-a" relantionship (inheritance)

import org.fasttrackit.Engine;

public class Car extends AutoVehicle {  // relatia de mostenire; clasa AutoVehicle este clasa parinte a lui Car

    private int doorCount;

    public Car(Engine engine) {  // oriunde in App.java va fi obligatoriu sa existe un engine, astfel constructorul trebuie apelat la fiecare new (); de tip Car si AutoVehicle
        super(engine);
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
    // "has-a" relationship (aggregation)



}
