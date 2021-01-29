package org.fasttrackit;

/**

 *
 */
public class App
{
    public static void main( String[] args )
    {
       Car carReference = new Car(); // prima variabila declarata

       carReference.name = "Ferrari";
       carReference.maxSpeed=300;
        carReference.fuellevel=60;
        carReference.mileage = 12.5;
        carReference.totalTravelDistance = 0;
        carReference.damaged = true;
        carReference.doorCount = 1;
        carReference.color = "Red";

        Engine engine1 = new Engine();
        engine1.manufacturer = "Ferrari";
        engine1.capacity = 5000;

        carReference.engine= engine1; // variabila engine este definita in Car.java

     System.out.println("Engine1 capacity " + engine1.capacity);
     System.out.println("Car engine capacity " + carReference.engine.capacity);

     engine1.capacity = 6000;

     System.out.println("Car engine capacity updated: " + carReference.engine.capacity); // modificarile se intampla in acelasi loc din memorie

        //concatenation
        System.out.println("Properties of car " + carReference.name);
        System.out.println("Maximum speed is: " + carReference.maxSpeed);
        System.out.println("Fuel level is: " + carReference.fuellevel);
        System.out.println("Mileage: " + carReference.mileage);
        System.out.println("Total travel distance: " + carReference.totalTravelDistance);
        System.out.println("Damage: " + carReference.damaged);
        System.out.println("Door count: " + carReference.doorCount);
        System.out.println("Color: " + carReference.color);
        System.out.println(carReference);

        Car car2 = new Car(); // o noua variabila
        car2.name = "Renault";
        car2.fuellevel = 70;
        car2.totalTravelDistance = 100;

        car2.engine = new Engine();
        car2.engine.capacity = 2000;

        System.out.println("Properties of car " + car2.name);
        System.out.println("Maximum speed is: " + car2.maxSpeed);
        System.out.println("Fuel level is: " + car2.fuellevel);
        System.out.println("Mileage: " + car2.mileage);
        System.out.println("Total travel distance: " + car2.totalTravelDistance);
        System.out.println("Damage: " + car2.damaged);
        System.out.println("Door count: " + car2.doorCount);
        System.out.println("Color: " + car2.color);

     System.out.println("Initial name for car1 " + carReference.name);
        carReference.name = "Audi";
     System.out.println("Changed name for car1 " + carReference.name);

     carReference = new Car();
     carReference.name = "BMW";
     System.out.println("New name for car1 " + carReference.name);


     carReference = car2;
     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.name);
     System.out.println("Name of car referenced from 2 variables; car2 " + car2.name);

     car2.name = "Dacia";

     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.name);
     System.out.println("Name of car referenced from 2 variables; car2 " + car2.name);

     car2 = null;

     System.out.println(carReference.name);
    }
}
