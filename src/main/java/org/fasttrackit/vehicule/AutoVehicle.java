package org.fasttrackit.vehicule;

import org.fasttrackit.Engine;

public class AutoVehicle extends Vehicle {

   private Engine engine; // clasa- Engine (trebuie sa existe Engine.java)  ;  variabila- engine

    // Constructor overloading
//    public AutoVehicle ()
//    {
//        this(new Engine());
//    }

    public AutoVehicle (Engine engine)  // Constructor
    {
        this.engine = engine;

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "AutoVehicle{" +
                "engine=" + engine +
                "} " + super.toString();
    }
}
