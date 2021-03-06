package org.fasttrackit;

import org.fasttrackit.competitor.Mobile;
import org.fasttrackit.competitor.vehicule.Car;
import org.fasttrackit.competitor.vehicule.Vehicle;
import org.fasttrackit.utils.ScannerUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game{

//    private Vehicle competitor1, competitor2;  // practic, datorita polimorfismului se pot declara 2 param

    private Track[] tracks = new Track[3];
    private List<Mobile>  competitors =  new ArrayList<>();
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();
    private boolean winnerNotKnown=true;
    private Track selectedTrack;

    public void start() throws Exception {  //metoda

        System.out.println("Welcome to the racing game!");

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser(); // pt ca metoda getSelectedTrackFromUser returneaza o variabila Track (din lista array)

        System.out.println("Selected track: " + selectedTrack.getName() + " with the length: " + selectedTrack.getLength());

        initialiseCompetitors();

        loopRounds();


    }

    private void loopRounds()
    {
        while ((winnerNotKnown) && (outOfRaceCompetitors.size() < competitors.size()))
        playOneRound();
    }

    private void playOneRound ()
    {
        System.out.println("New round.");

//        for (int i=0; i < competitors.size(); i++)
//        {
//            Vehicle competitor = competitors.get(i);
//            System.out.println("It's " + competitor.getName() + "s turn.");
//
//            competitor.accelerate(100);
//        }

        // enhanced for (for-each)
        for (Mobile competitor:competitors)  // aici s-a initializat competitor
        {
            System.out.println("It's " + competitor.getName() + "s turn.");

            if(!competitor.canMove())
            {
                System.out.println("Sorry, you cannot continue the race..");
                outOfRaceCompetitors.add(competitor);
                continue;
            }


        double speed = getAccelerationSpeedFromUser();
        competitor.accelerate(speed, 1);

        if(competitor.getTotalTravelDistance() >= selectedTrack.getLength())
        {
            System.out.println("The winner is: " + competitor.getName());
            winnerNotKnown=false;
            break;
        }
        }

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
        int i;
        System.out.println("Nb. of players: " + playerCount);

        for( i =1; i<= playerCount; i++) {

            System.out.println("Preparing player " + i + " for the race");
            Vehicle vehicle = new Car();
            vehicle.setName(getVehicleNameFromUSer());
            vehicle.setFuellevel(30);
            vehicle.setMaxSpeed(300);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8, 15));

            System.out.println("Fuel level for " + vehicle.getName() + " : " + vehicle.getFuellevel());
            System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
            System.out.println("Mileage for " + vehicle.getName() + " : " + vehicle.getMileage());

            competitors.add(vehicle); }




//        String vehicleName = getVehicleNameFromUSer();
//
//        System.out.println("Vehicle name: " + vehicleName);

    }


    private int getPlayerCountFromUser()
    {
        System.out.println("Please enter number of players: ");
        return ScannerUtils.nextIntAndMoveToNextLine();  // cin>>

    }

    private String getVehicleNameFromUSer()
    {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtils.nextLine();
    }

    private Track getSelectedTrackFromUser() throws Exception {
        System.out.println("Please select a track: ");

        try {
            int trackNumber = ScannerUtils.nextIntAndMoveToNextLine();  // citirea din compilator; citire care trebuie sa fie de tip int; 'cin>>' din C++;

            return tracks[trackNumber - 1]; // -1 pt ca indexul incepe de la zero in array; returneaza obiectul din tracks, cu toate proprietatile lui; (Name si Length)

        } catch (InputMismatchException e) {

            throw new Exception("You have entered an invalid value!");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("You have entered an invalid number!"); // Unchecked exception, deci nu trebuie tratata
        } finally {
            System.out.println("Finally bloc is always executed!");
        }
    }

    private double getAccelerationSpeedFromUser()
    {
        System.out.println("Please enter acceleration speed: ");
        return ScannerUtils.nextDoubleAndMoveToNextLine();  // cin>>
    }

}
