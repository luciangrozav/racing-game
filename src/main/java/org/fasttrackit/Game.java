package org.fasttrackit;

import org.fasttrackit.utils.ScannerUtils;

public class Game{

//    private Vehicle competitor1, competitor2;  // practic, datorita polimorfismului se pot declara 2 param

    private Track[] tracks = new Track[3];

    public void start(){  //metoda

        System.out.println("Welcome to the racing game!");

        initializeTracks();


        int playerCount = getPlayerCountFromUser();

        System.out.println("Nb. of players: " + playerCount);

        String vehicleName = getVehicleNameFromUSer();

        System.out.println("Vehicle name: " + vehicleName);

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

        displayTracks();

    }

    private void displayTracks(){
        //classical for
        for(int i=0; i< tracks.length; i++)
            if(tracks[i] != null)  // altfel da eroare la afisare
            {  System.out.println((i+1) + ". " + tracks[i].getName() + ": " + tracks[i].getLength() + " km"); }
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

}
