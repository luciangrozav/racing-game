package org.fasttrackit.service;

import org.fasttrackit.controller.StdinController;
import org.fasttrackit.controller.UserInputController;
import org.fasttrackit.controller.utils.ScannerUtils;
import org.fasttrackit.domain.Track;
import org.fasttrackit.domain.competitor.Hulk;
import org.fasttrackit.domain.competitor.Mobile;
import org.fasttrackit.domain.competitor.MobileComparator;
import org.fasttrackit.domain.competitor.vehicule.Car;
import org.fasttrackit.domain.competitor.vehicule.CheatingVehicle;
import org.fasttrackit.domain.competitor.vehicule.Vehicle;
import org.fasttrackit.persistency.FileRankingRepository;
import org.fasttrackit.persistency.RankingsRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

//    private Vehicle competitor1, competitor2;  // practic, datorita polimorfismului se pot declara 2 param

    private Track[] tracks = new Track[3];
    private List<Mobile> competitors = new ArrayList<>();
    private Set<Mobile> outOfRaceCompetitors = new HashSet<>();
    private boolean winnerNotKnown = true;
    private Track selectedTrack;

    private UserInputController userInputController = new StdinController(); // obiect interfata - new clasa

    private RankingsRepository rankingsRepository = new FileRankingRepository();

    public void start() throws Exception {  //metoda ; Exception este tratat

        System.out.println("Welcome to the \"Racing game!\" \u26D0\n");

        initializeTracks();

        selectedTrack = getSelectedTrackFromUser(); // pt ca metoda getSelectedTrackFromUser returneaza o variabila Track (din lista array)

        System.out.println("Selected track: " + selectedTrack.getName() + " with the length: " + selectedTrack.getLength());
        System.out.println();

        initialiseCompetitors();

        loopRounds();
        processRankings();


    }

    private void processRankings() {

        competitors.sort(Collections.reverseOrder(new MobileComparator()));

        System.out.println("Rankings:");

        for (int i = 0; i < competitors.size(); i++)
        { System.out.println((i + 1) + ". " + competitors.get(i).getName() + ": " + competitors.get(i).getTotalTravelDistance() + " km");

        rankingsRepository.addRankingItem(i+1, competitors.get(i).getName(), competitors.get(i).getTotalTravelDistance());}

    rankingsRepository.close();
    }



    private void loopRounds() {
        while ((winnerNotKnown) && (outOfRaceCompetitors.size() < competitors.size()))
            playOneRound();
    }

    private void playOneRound() {
        System.out.println("New round.");

//        for (int i=0; i < competitors.size(); i++)
//        {
//            Vehicle competitor = competitors.get(i);
//            System.out.println("It's " + competitor.getName() + "s turn.");
//
//            competitor.accelerate(100);
//        }

        // enhanced for (for-each)
        for (Mobile competitor : competitors)  // aici s-a initializat competitor
        {
            System.out.println();
            System.out.println("It's " + competitor.getName() + "s turn.");

            if (!competitor.canMove()) {
                System.out.println("Sorry, you cannot continue the race..");
                outOfRaceCompetitors.add(competitor);
                continue;
            }


            double speed = getAccelerationSpeedFromUser();
            competitor.accelerate(speed, 1);

            if (competitor.getTotalTravelDistance() >= selectedTrack.getLength()) {
                System.out.println();
                System.out.println("The winner is: " + competitor.getName());
                System.out.println();
                winnerNotKnown = false;
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
        tracks[1] = track2;

        Track track3 = new Track();
        track3.setName("Forrest Circuit");
        track3.setLength(300);
        tracks[2] = track3;

        displayTracks();

    }

    private void displayTracks() {

        System.out.println("Available tracks: ");
        //classical 'for'
        for (int i = 0; i < tracks.length; i++)
            if (tracks[i] != null)  // altfel da eroare la afisare
            {
                System.out.println((i + 1) + ". " + tracks[i].getName() + ": " + tracks[i].getLength() + " km");
            }
        System.out.println();
    }

    private void initialiseCompetitors() {

        int playerCount = userInputController.getPlayerCount();
        int i;
        System.out.println("Nb. of players: " + playerCount);
        System.out.println();

        for (i = 1; i <= playerCount; i++) {

            System.out.println("Preparing player " + i + " for the race");
           Mobile mobile = createCompetitor();

            competitors.add(mobile);
        }


//        String vehicleName = getVehicleNameFromUSer();
//
//        System.out.println("Vehicle name: " + vehicleName);

    }

    private void displayCompetitorTypes (){

        System.out.println();
        System.out.println("How do you like to enter the race?");
        System.out.println("1. Using a car");
        System.out.println("2. I feel lucky, I'll try Hulk");

    }

    private Mobile createCompetitor(){

        displayCompetitorTypes();

        int competitorType = userInputController.getCompetitorType();

     switch (competitorType)
     {
         case 1:
             Car car = new Car();
             setCommonVehicleProperties(car);
             return car;

         case 2:
             System.out.println("Hulk is here!");
             return new Hulk();

         case 0:
             CheatingVehicle cheatingVehicle = new CheatingVehicle();
             setCommonVehicleProperties(cheatingVehicle);
             return cheatingVehicle;

         default:
             System.out.println("Please select a valid option");
             return createCompetitor(); // recursivitate
     }
    }

    private void setCommonVehicleProperties( Vehicle vehicle ) {

        vehicle.setName(userInputController.getVehicleName());
        vehicle.setFuellevel(30);
        vehicle.setMaxSpeed(300);
        vehicle.setMileage(ThreadLocalRandom.current().nextDouble(8, 15));

        System.out.println("Fuel level for " + vehicle.getName() + " : " + vehicle.getFuellevel());
        System.out.println("Max speed for " + vehicle.getName() + " : " + vehicle.getMaxSpeed());
        System.out.println("Mileage for " + vehicle.getName() + " : " + vehicle.getMileage());
        System.out.println();
    }


    private int getPlayerCountFromUser() {
        System.out.println("Please enter number of players: ");
        return ScannerUtils.nextIntAndMoveToNextLine();  // cin>>

    }

    private String getVehicleNameFromUSer() {
        System.out.println("Please enter vehicle name: ");
        return ScannerUtils.nextLine();
    }

    private Track getSelectedTrackFromUser() throws Exception { // Exception este tratat de catre programator

        try {
            int trackNumber = userInputController.getSelectedTrack();  // citirea din compilator; citire care trebuie sa fie de tip int; 'cin>>' din C++;

            return tracks[trackNumber - 1]; // -1 pt ca indexul incepe de la zero in array; returneaza obiectul din tracks, cu toate proprietatile lui; (Name si Length)

        } catch (InputMismatchException e) {

            throw new Exception("You have entered an invalid value!");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("You have entered an invalid number!");
        } // Unchecked exception, deci nu trebuie tratata
//         finally {
//            System.out.println("Finally bloc is always executed!");
//        }
    }

    private double getAccelerationSpeedFromUser() {

        try {
            return userInputController.getAccelerationSpeed();  // cin>>
        } catch (InputMismatchException e) {
            System.out.println("Invalid value. Please try again.");
            return getAccelerationSpeedFromUser(); // recursivitate- o functie se apeleaza pe ea insasi
        }
    }

//    public static void main(String[] args) {
//        System.out.println("Enter number: ");
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            int i = scanner.nextInt();
//            System.out.println("Entered: " + i);
//        } catch (InputMismatchException e) {
//            System.out.println("Invalid number.");
//        } finally  { scanner.nextLine();}
//        int i2 = scanner.nextInt();
//        System.out.println("Re-entered: " + i2);
//    }
}