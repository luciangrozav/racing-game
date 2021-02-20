package org.fasttrackit;

public class App
{
    public static void main( String[] args )
    {
//        for(int i=0; i< args.length;i++)
//        {
//            System.out.println(args[i]);
//        }

       Game game = new Game();
        game.start();

//        String email= "luciangrozav01@gmail.com";
//        String[] emailParts = email.split("@");
//
//        System.out.println("First part: " + emailParts[0]);
//        System.out.println("Second part: " + emailParts[1]);

//        Vehicle cheatingVehicle =  new CheatingVehicle();  // Polimorfismul creste flexibilitatea in dezvoltarea aplicatiei
//        cheatingVehicle.setName("Cheater");
//        cheatingVehicle.accelerate(60);
//
//      if (cheatingVehicle instanceof CheatingVehicle)  // daca cheatingVehicle este o instanta a clasei CheatingVehicle, atunci ii fac typecasting
//       // type casting
//        ((CheatingVehicle)cheatingVehicle).cheat();  // -> trateaza continutul variabilei ca si cum ar fi de tip CheatingVehicle

//        CheatingVehicle newVar = (CheatingVehicle) cheatingVehicle;
//        newVar.cheat();                                               // -> echivalent

        // invoking overloading methods and constructors
//        Engine engine = new Engine();
//        engine.setManufacturer("Renault");
//        engine.setCapacity(2000);
//
//        AutoVehicle autovehicle1 = new AutoVehicle(engine);
//
//        new Car();
//
//        autovehicle1.accelerate (100);  // metoda accelerate se poate apela in 2 moduri - rolul supraincarcarii
//        autovehicle1.accelerate (100,3);


//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.setName("Dacia");
//
//        Vehicle vehicle2 = new Vehicle();
//        vehicle2.setName("Lada");
//
//        System.out.println("Total count from Vehicle " + vehicle1.getName() + " : " + vehicle1.getTotalVehicleCount());
//        System.out.println("Total count from Vehicle " + vehicle2.getName() + " : " + vehicle2.getTotalVehicleCount());
//        System.out.println("Total count from Vehicle class " + Vehicle.getTotalVehicleCount());
//
//
//         Engine autoVehicleEngine = new Engine();  // ai declarat 1 engine
//        autoVehicleEngine.setManufacturer("Vw");
//        AutoVehicle autoVehicle = new AutoVehicle(autoVehicleEngine); // de acum oricarui Autovehicul ii va fi obligatoriu sa i se instantieze un motor
//
//        Engine engine1 = new Engine();  // ai declarat alt engine ; cele 2 engine le declari in clasele AutoVehicle si Car
//        engine1.setManufacturer("Ferrari");
//        engine1.setCapacity(5000);
////
////
//        Car carReference = new Car(engine1); // prima variabila declarata ; in paranteze introduci variabila engine declarata mai sus
////
//       carReference.setName("Ferrari");    // Date FERRARI
//       carReference.setMaxSpeed(300);
//        carReference.setFuellevel(60);
//        carReference.setMileage(12.5);
//        carReference.setTotalTravelDistance(0);
//        carReference.setDamaged(false);
//        carReference.setDoorCount(1);
//        carReference.setColor("Red");
//
//        System.out.println(carReference);
//
//
//     System.out.println("Engine1 capacity " + engine1.getCapacity());
//     System.out.println("Car engine capacity " + carReference.getEngine().getCapacity());
//
//     engine1.setCapacity(6000);
//
//     System.out.println("Car engine capacity updated: " + carReference.getEngine().getCapacity()); // modificarile se intampla in acelasi loc din memorie
//
//        //concatenation
//        System.out.println("Properties of car " + carReference.getName());
//        System.out.println("Maximum speed is: " + carReference.getMaxSpeed());
//        System.out.println("Fuel level is: " + carReference.getFuellevel());
//        System.out.println("Mileage: " + carReference.getMileage());
//        System.out.println("Total travel distance: " + carReference.getTotalTravelDistance());
//        System.out.println("Damage: " + carReference.isDamaged());
//        System.out.println("Door count: " + carReference.getDoorCount());
//        System.out.println("Color: " + carReference.getColor());
//        System.out.println(carReference);
//
//        Engine engine2 = new Engine();
//        Car car2 = new Car(engine2); // Date RENAULT
//        car2.setName("Renault");
//        car2.setMaxSpeed(300);
//        car2.setMileage(10);
//        car2.setFuellevel(70);
//        car2.setTotalTravelDistance(100);
//        car2.getEngine().setCapacity(2000);
//
//        System.out.println("Properties of car " + car2.getName());
//        System.out.println("Maximum speed is: " + car2.getMaxSpeed());
//        System.out.println("Fuel level is: " + car2.getFuellevel());
//        System.out.println("Mileage: " + car2.getMileage());
//        System.out.println("Total travel distance: " + car2.getTotalTravelDistance());
//        System.out.println("Damage: " + car2.isDamaged());
//        System.out.println("Door count: " + car2.getDoorCount());
//        System.out.println("Color: " + car2.getColor());
//
//        System.out.println(carReference.getName() + ":");
//
//        double distanceforCar1 = carReference.accelerate(60, 1); // Ferrari are viteza- 60  ; !! metoda accelerate returneaza o distanta, de aceea ii atribui o distanta
//
//        System.out.println(car2.getName() + ":");
//        double distanceforCar2 = car2.accelerate(140, 1);  // Renault are viteza- 140 ; !! metoda accelerate returneaza o distanta, de aceea ii atribui o distanta
//
//        if (distanceforCar1 > distanceforCar2) {
//            System.out.println("Longest distance was covered by: " + carReference.getName());
//        } else System.out.println("Longest distance was covered by: " + car2.getName());
//
//        System.out.println("Engine manufacturer before repair: " + carReference.getEngine().getManufacturer());
//    Mechanic mechanic = new Mechanic();
//    mechanic.repair(carReference);
//
//        System.out.println("Engine manufacturer after repair: " + carReference.getEngine().getManufacturer()); // in clasa Mechanic- ii s-a atribuit lui Autovehicle un nou motor- deci va avea o valoare random = null; (regula)
//    System.out.println("Initial name for car1 " + carReference.getName());
//        carReference.setName("Audi");
//     System.out.println("Changed name for car1 " + carReference.getName());
//
//    carReference = new Car(new Engine());
//   carReference.setName("BMW");
//     System.out.println("New name for car1 " + carReference.getName());
//
//
//    carReference = car2;
//     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.getName());
//     System.out.println("Name of car referenced from 2 variables; car2 " + car2.getName());
//
//     car2.setName("Dacia");
//
//     System.out.println("Name of car referenced from 2 variables; carReference " + carReference.getName());
//     System.out.println("Name of car referenced from 2 variables; car2 " + car2.getName());

    }

}
