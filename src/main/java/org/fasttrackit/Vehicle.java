package org.fasttrackit;

public class Vehicle { //Vehicle este stramos de-al lui Car

    String name;
    double fuellevel;
    double mileage;
    double totalTravelDistance;
    double maxSpeed;

    boolean damaged;
    String color;

    public double accelerate (double speed, double durationInHours) {  // accelerate= metoda -> reprezinta o actiune, un verb-accelerare; speed, durationInHours- parametrii

        // Ferrari is accelerating with 100 Km/h for 1h
        System.out.println(name + " is accelerating with" + speed + " Km/h for " + durationInHours + " hours");
        double distance = speed * durationInHours;  // distance- variabila locala, exista doar intre acoladele lui 'accelerate'

        totalTravelDistance = totalTravelDistance + distance; // totalTravelDistance += distance;

        System.out.println("Total traveled distance for vehicle " + name + " : " + totalTravelDistance);

        double usedFuel = distance * mileage / 100;

        fuellevel -= usedFuel;
        System.out.println("Remaining fuel for vehicle " + name + " : " + fuellevel);

        return distance;

    }

}
