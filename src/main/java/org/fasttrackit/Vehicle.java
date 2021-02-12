package org.fasttrackit;

import java.time.LocalDate;

public class Vehicle { //Vehicle este stramos de-al lui Car

    static int totalVehicleCount;  // variabila de clasa / variabila statica

    String name;
    double fuellevel;
    double mileage;
    double totalTravelDistance;
    double maxSpeed;

    boolean damaged;  // 2 valori- true, false- ori e stricat ori merge;
    String color;

    LocalDate manufacturingDate = LocalDate.now();

    public Vehicle() {
        totalVehicleCount++;
    }

    /* public Vehicle(String name, double fuellevel, double mileage, double maxSpeed) {    // exemplu de alt constructor;
        this.name = name;                                                                 // Si in Autovehicle si Car trebuie definiti dupa, pt ca Vehicle este stramos
        this.fuellevel = fuellevel;
        this.mileage = mileage;
        this.maxSpeed = maxSpeed;
    } */

    public double accelerate (double speed, double durationInHours) {  // accelerate= metoda -> reprezinta o actiune, un verb-accelerare; speed, durationInHours- parametrii

        if (fuellevel <= 0 || damaged) { // se inteteste povestea aplicatiei, ii creste complexitatea, conditiile
            System.out.println("You cannot accelerate");
        }
        if (speed > maxSpeed)
        {
            System.out.println("Maxspeed exceeded!");
            return 0;  //
        } else if (speed== maxSpeed) {
            System.out.println("Careful! Maxspeed reached!");
        } else {
            System.out.println("Valid speed");
        }

        System.out.println(name + " is accelerating with " + speed + " Km/h for " + durationInHours + " hours");
        double distance = speed * durationInHours;  // distance- variabila locala, exista doar intre acoladele lui 'accelerate'

        totalTravelDistance = totalTravelDistance + distance; // totalTravelDistance += distance;

        System.out.println("Total traveled distance for vehicle " + name + " : " + totalTravelDistance + " Km");

        double mileageMultiplier = 1;
        if (speed> 120)
        {
            mileageMultiplier = speed / 100;
        }

        double usedFuel = distance * mileage * mileageMultiplier / 100;

        fuellevel -= usedFuel;
        System.out.println("Remaining fuel for vehicle " + name + " : " + fuellevel);

        return distance;  //metoda accelerate returneaza valoarea distance (valoare double)

    }

}
