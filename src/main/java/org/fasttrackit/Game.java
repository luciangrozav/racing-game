package org.fasttrackit;

import org.fasttrackit.utils.ScannerUtils;
import org.fasttrackit.vehicule.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Game{

//    private Vehicle competitor1, competitor2;  // practic, datorita polimorfismului se pot declara 2 param

    private Track[] tracks = new Track[3];
    private List<Vehicle>  competitors =  new ArrayList<>();

    public void start(){  //metoda

        System.out.println("Welcome to the racing game!");

        initializeTracks();

        Track selectedTrack = getSelectedTrackFromUser(); // pt ca metoda getSelectedTrackFromUser returneaza o variabila Track (din lista array)

        System.out.println("Selected track: " + selectedTrack.getName() + " with the length: " + selectedTrack.getLength());

        initialiseCompetitors();
    }

    private void initializeTracks() {
        Track track1 = new Track();
        track1.setName("Highway");
        track1.setLength(200);
        tracks[0] = track1;

        Track track2 = new Track();
        track2.setName("Street Circuit");
        track2.setLength(100);
        tracks[1]=track2;

        Track track3 = new Track();
        track3.setName("Forrest Circuit");
        track3.setLength(300);
        tracks[2]=track3;

        displayTracks();

    }

    private void displayTracks(){

        System.out.println("Available tracks: ");
        //classical 'for'
        for(int i=0; i< tracks.length; i++)
            if(tracks[i] != null)  // altfel da eroare la afisare
            {  System.out.println((i+1) + ". " + tracks[i].getName() + ": " + tracks[i].getLength() + " km"); }
    }

    private void initialiseCompetitors(){

        int playerCount = getPlayerCountFromUser();

        //System.out.println("Nb. of players: " + playerCount);

        for(int i =1; i< playerCount-1; i++){
            System.out.println("Preparing player " + i + " for the race");
            Vehicle vehicle = new Vehicle();
            vehicle.setName(getVehicleNameFromUSer());
            vehicle.setFuellevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(10);

            System.out.println("Fuel level for " + vehicle.getName() + " : " + vehicle.getFuellevel());
            System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
            System.out.println("Mileage for " + vehicle.getName() + " : " + vehicle.getMileage());

            competitors.add(vehicle);

        }

        String vehicleName = getVehicleNameFromUSer();

        System.out.println("Vehicle name: " + vehicleName);

    }


    private int getPlayerCountFromUser()
    {
        System.out.println("Please enter number of players: ");
        return ScannerUtils.nextIntAndMoveToNextLine();

    }

    private String getVehicleNameFromUSer()
    {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtils.nextLine();
    }

    private Track getSelectedTrackFromUser()
    {
        System.out.println("Please select a track: ");
        int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();  // citirea din compilator; citire care trebuie sa fie de tip int; 'cin>>' din C++;

        return tracks[trackNumber -1]; // -1 pt ca indexul incepe de la zero in array; returneaza obiectul din tracks, cu toate proprietatile lui; (Name si Length)
    }

}
