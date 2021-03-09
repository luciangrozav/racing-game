package org.fasttrackit.competitor.vehicule;

import org.fasttrackit.competitor.Mobile;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicle implements Mobile { //Vehicle este stramos de-al lui Car

   private static int totalVehicleCount;  // variabila de clasa / variabila statica

   private String name;
   private double fuellevel;
   private double mileage;
   protected double totalTravelDistance;
   private double maxSpeed;

   private boolean damaged;  // 2 valori- true, false- ori e stricat ori merge;
   private String color;

    private LocalDate manufacturingDate = LocalDate.now();

    public Vehicle() {
        totalVehicleCount++;
    }

    @Override
    public boolean canMove() {
        return fuellevel>0 && !damaged;
    }

    //    public Vehicle(Engine engine) {
//
//    }

    /* public Vehicle(String name, double fuellevel, double mileage, double maxSpeed) {    // exemplu de alt constructor;
        this.name = name;                                                                 // Si in Autovehicle si Car trebuie definiti dupa, pt ca Vehicle este stramos
        this.fuellevel = fuellevel;
        this.mileage = mileage;
        this.maxSpeed = maxSpeed;
    } */

    public double accelerate (double speed)  //overloading la metoda accelerate
    {
        return accelerate(speed, 1);
    }

    public double accelerate (double speed, double durationInHours) {  // accelerate= metoda -> reprezinta o actiune, un verb-accelerare; speed, durationInHours- parametrii

        if (!canMove()) { // se inteteste povestea aplicatiei, ii creste complexitatea, conditiile
            System.out.println("You cannot accelerate");
            return 0;
        }
        if (speed > maxSpeed)
        {
            System.out.println("Maxspeed exceeded!");
            return 0;  //
        } else if (speed== maxSpeed) {
            System.out.println("Careful! Maxspeed reached!");
        } else if (speed < maxSpeed){
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

    protected Vehicle reset()
    {
        totalTravelDistance = 0;
        damaged= false;

        return this;  // returneaza obiectul curent = this
    }

    public void setName(String name)
    {
    this.name = name.trim(); // sterge spatiile de la inceput si sfarsit
    }
    public String getName()
    {
        return name;
    }

    public double getFuellevel() {
        return fuellevel;
    }

    public void setFuellevel(double fuellevel) {
        this.fuellevel = fuellevel;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getTotalTravelDistance() {
        return totalTravelDistance;
    }

    public void setTotalTravelDistance(double totalTravelDistance) {
        this.totalTravelDistance = totalTravelDistance;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    // read-only property
    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", fuellevel=" + fuellevel +
                ", mileage=" + mileage +
                ", totalTravelDistance=" + totalTravelDistance +
                ", maxSpeed=" + maxSpeed +
                ", damaged=" + damaged +
                ", color='" + color + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.fuellevel, fuellevel) == 0 && Double.compare(vehicle.mileage, mileage) == 0 && Double.compare(vehicle.totalTravelDistance, totalTravelDistance) == 0 && Double.compare(vehicle.maxSpeed, maxSpeed) == 0 && damaged == vehicle.damaged && Objects.equals(name, vehicle.name) && Objects.equals(color, vehicle.color) && Objects.equals(manufacturingDate, vehicle.manufacturingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fuellevel, mileage, totalTravelDistance, maxSpeed, damaged, color, manufacturingDate);
    }
}
