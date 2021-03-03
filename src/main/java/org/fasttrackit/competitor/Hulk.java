package org.fasttrackit.competitor;

import java.util.concurrent.ThreadLocalRandom;

public class Hulk implements  Mobile {

    private double totalTravelDistance;
    private boolean cooperative;

    public Hulk() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 100);

        if (randomNumber <= 19)
            cooperative=true;

    }

    @Override
    public double accelerate(double speed, double durationInHours) {
        System.out.println("Hulk is accelerating with:" + speed + " km/h for: " + durationInHours + "h.");

        double distance = speed * durationInHours;
        totalTravelDistance+=distance;
    }

    @Override
    public double getTotalTravelDistance() {
        return totalTravelDistance;
    }

    @Override
    public boolean canMove() {
        return cooperative;
    }

    @Override
    public String getName() {
        return "Hulk";
    }
}
