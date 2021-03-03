package org.fasttrackit.competitor.vehicule;

public class CheatingVehicle extends Vehicle {  // CheatingVehicle e o subclasa


    @Override  // metoda accelerate suprascrisa
    public double accelerate(double speed, double durationInHours) {
       // return super.accelerate(speed, durationInHours); - vrem sa schimbam comportamentul; fara super, metoda s-ar apela intr-o bucla infinita (pe ea insasi la infinit)

        System.out.println(getName() + " is accelerating with " + speed + " Km/h for " + durationInHours + " hours");
        System.out.println("Cheater!!!");

        double distance = speed * durationInHours * 2;  // fizica
        totalTravelDistance += distance;

        System.out.println("Total traveled distance for vehicle " + getName() + " : " + totalTravelDistance + " Km");

        return distance;

    }

    // co-variant return type
    @Override
    public CheatingVehicle reset() {
        super.reset();
        return this;
    }

    public void cheat()
    {
        totalTravelDistance*= 2;
        System.out.println("Updated total distance: " + totalTravelDistance);
    }  // metoda cheat

}
