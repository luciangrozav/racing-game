package org.fasttrackit.competitor;

import java.util.Objects;
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

        return distance;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hulk hulk = (Hulk) o;
        return Double.compare(hulk.totalTravelDistance, totalTravelDistance) == 0 && cooperative == hulk.cooperative;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalTravelDistance, cooperative);
    }
}
