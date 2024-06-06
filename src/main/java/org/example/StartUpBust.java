package org.example;

import java.util.ArrayList;

public class StartUpBust {
    public static void main(String[] args) {
        String[] names = {"rapidkl", "shopee", "remitly"};
        GameHelper helper = new GameHelper();                   //initialise helper
        ArrayList<Startup> startups = new ArrayList<>();        //initialise startups arraylist
        for (int i = 0; i < 3; i++) {                                 //create 3 startups
            startups.add(new Startup(names[i]));
            ArrayList<String> location = helper.makeLocations(); //get helper to generate a random location
            startups.get(i).setLocation(location);           //pass the location into the startup
        }
        int emptyCount = 0;
        while (emptyCount <3) {
            String result = "miss";
            String userInput = helper.getUserInput();            //get user input
            for (Startup startup : startups) {                    //iterate through each startup
                if (startup.getLocation().contains(userInput)) { //if the current startup contains userInput
                    startup.getLocation().remove(userInput);     //remove userInput from the ArrayList<String> location
                    result = "hit";
                    if (startup.getLocation().isEmpty()) {
                        System.out.println(startup.getName() + " has been killed!");
                        emptyCount++;
                    }
                }
            }
            System.out.println(result + "\n");

            for (Startup i : startups) {
                System.out.println(i.getName());
                System.out.println(i.getLocation());
            }
        }
        System.out.println("you killed all the startups, congrats!\nYour stocks are now worthless");
    }
}


/*     Board
*      0   1   2   3   4   5   6   7
*   A |   |   |   |   |   |   |   |
* -------------------------------------
*   B |   |   |   |   |   |   |   |
*  ------------------------------------
*   C |   |   |   |   |   |   |   |
*  ------------------------------------
*   D |   |   |   |   |   |   |   |
*  ------------------------------------
*   E |   |   |   |   |   |   |   |
*  ------------------------------------
*   F |   |   |   |   |   |   |   |
*  ------------------------------------
*   G |   |   |   |   |   |   |   |
*  ------------------------------------
*
* */