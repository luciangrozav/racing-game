package org.fasttrackit;

import org.fasttrackit.utils.ScannerUtils;

public class Game{

    ScannerUtils scannerUtils = new ScannerUtils();  // ceea ce intra in sistem de la tastatura; ce scrie userul de la tastatura

    public void start(){  //metoda

        System.out.println("Welcome to the racing game!");
        int playerCount = getPlayerCountFromUser();
        System.out.println("Nb. of players: " + playerCount);
        String vehicleName = getVehicleNameFromUSer();
        System.out.println("Vehicle name: " + vehicleName);
    }

    private int getPlayerCountFromUser()
    {
        System.out.println("Please enter number of players: ");
        return scannerUtils.nextIntAndMoveToNextLine();

    }

    private String getVehicleNameFromUSer()
    {
        System.out.println("Please enter vehicle name: ");
        return scannerUtils.nextLine();
    }

}
