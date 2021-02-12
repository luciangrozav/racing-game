package org.fasttrackit;

public class App
{
    public static void main( String[] args )
    {
       Game game = new Game();
        game.start();

        Vehicle vehicle1 = new Vehicle();
        System.out.println("Date: " + vehicle1.manufacturingDate);

       /*Exemplu variabile statice
        Vehicle vehicle1 = new Vehicle();
        vehicle1.name = "Dacia";
        vehicle1.totalVehicleCount = 1;

        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle();

        vehicle2.name = "Lada";
        vehicle2.totalVehicleCount = 3;
        System.out.println("Total count from Vehicle " + vehicle1.name + " : " + vehicle1.totalVehicleCount);

        System.out.println("Total count from Vehicle " + vehicle2.name + " : " + vehicle2.totalVehicleCount);
        System.out.println("Total count from Vehicle class " + Vehicle.totalVehicleCount); */


        /* Engine autoVehicleEngine = new Engine();  // ai declarat 1 engine
        autoVehicleEngine.manufacturer = "Vw";
        AutoVehicle autoVehicle = new AutoVehicle(autoVehicleEngine); // de acum oricarui Autovehicul ii va fi obligatoriu sa i se instantieze un motor

        Engine engine1 = new Engine();  // ai declarat alt engine ; cele 2 engine le declari in clasele AutoVehicle si Car
        engine1.manufacturer = "Ferrari";
        engine1.capacity = 5000;


        Car carReference = new Car(engine1); // prima variabila declarata ; in paranteze introduci variabila engine declarata mai sus

       carReference.name = "Ferrari";    // Date FERRARI
       carReference.maxSpeed=300;
        carReference.fuellevel=60;
        carReference.mileage = 12.5;
        carReference.totalTravelDistance = 0;
        carReference.damaged = false;
        carReference.doorCount = 1;
        carReference.color = "Red";


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

        Engine engine2 = new Engine();
        Car car2 = new Car(engine2); // Date RENAULT
        car2.name = "Renault";
        car2.maxSpeed = 300;
        car2.mileage = 10;
        car2.fuellevel = 70;
        car2.totalTravelDistance = 100;
        car2.engine.capacity = 2000;

        System.out.println("Properties of car " + car2.name);
        System.out.println("Maximum speed is: " + car2.maxSpeed);
        System.out.println("Fuel level is: " + car2.fuellevel);
        System.out.println("Mileage: " + car2.mileage);
        System.out.println("Total travel distance: " + car2.totalTravelDistance);
        System.out.println("Damage: " + car2.damaged);
        System.out.println("Door count: " + car2.doorCount);
        System.out.println("Color: " + car2.color);

        System.out.println(carReference.name + ":");

        double distanceforCar1 = carReference.accelerate(60, 1); // Ferrari are viteza- 60  ; !! metoda accelerate returneaza o distanta, de aceea ii atribui o distanta

        System.out.println(car2.name + ":");
        double distanceforCar2 = car2.accelerate(140, 1);  // Renault are viteza- 140 ; !! metoda accelerate returneaza o distanta, de aceea ii atribui o distanta

        if (distanceforCar1 > distanceforCar2) {
            System.out.println("Longest distance was covered by: " + carReference.name);
        } else System.out.println("Longest distance was covered by: " + car2.name);

        System.out.println("Engine manufacturer before repair: " + carReference.engine.manufacturer);
    Mechanic mechanic = new Mechanic();
    mechanic.repair(carReference); */

       // System.out.println("Engine manufacturer after repair: " + carReference.engine.manufacturer); // in clasa Mechanic- ii s-a atribuit lui Autovehicle un nou motor- deci va avea o valoare random = null; (regula)
//     System.out.println("Initial name for car1 " + carReference.name);
//        carReference.name = "Audi";
//     System.out.println("Changed name for car1 " + carReference.name);
//
//     carReference = new Car();
//     carReference.name = "BMW";
//     System.out.println("New name for car1 " + carReference.name);
//
//
//     carReference = car2;
//     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.name);
//     System.out.println("Name of car referenced from 2 variables; car2 " + car2.name);
//
//     car2.name = "Dacia";
//
//     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.name);
//     System.out.println("Name of car referenced from 2 variables; car2 " + car2.name);
//
//     car2 = null;
//
//     System.out.println(carReference.name);
    }
}
