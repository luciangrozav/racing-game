package org.fasttrackit;

public class Mechanic {

    public void repair (AutoVehicle autoVehicle) {  // metoda repair nu va returna nimic -> void ;  ii atribui acestei metode un obiect de clasa Autvehicle
        // in Autovehicle este clasa Engine; astfel spunem ca mecanicul poate schimba/repara motorul
        // de aceea ne folosim de clasa Autovehicle in declararea metodei

        autoVehicle.engine = new Engine(); // lui autovehicle ii s-a atribuit un nou motor
        autoVehicle.damaged = false;  // damaged este o proprietate mostenita din clasa Vehicle



    }

}
