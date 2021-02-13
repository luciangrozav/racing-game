package org.fasttrackit;

public class AutoVehicle extends Vehicle{

   private Engine engine; // clasa- Engine (trebuie sa existe Engine.java)  ;  variabila- engine

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
}
