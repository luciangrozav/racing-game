package org.fasttrackit.domain.competitor.vehicule;

// "is-a" relantionship (inheritance)

public class Car extends Vehicle {  // relatia de mostenire; clasa AutoVehicle este clasa parinte a lui Car

    private int doorCount;


//    public Car(Engine engine) {  // oriunde in App.java va fi obligatoriu sa existe un engine, astfel constructorul trebuie apelat la fiecare new (); de tip Car si AutoVehicle
//        super(engine);
//    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
    // "has-a" relationship (aggregation)


    @Override
    public String toString() {
        return "Car{" +
                "doorCount=" + doorCount +
                "} " + super.toString();
    }
}
