package org.example;

import java.util.ArrayList;

public class StartUpBust {
    public static void main(String[] args) {
        String[] names = {"rapidkl", "shopee", "remitly"};
        GameHelper helper = new GameHelper();                   //initialise helper
        ArrayList<Startup> startups = new ArrayList<>();        //initialise startups arraylist
        for (int i = 0; i < 3; i++) {                           //create 3 startups
            startups.add(new Startup(names[i]));
            ArrayList<String> location = helper.makeLocations(); //get helper to generate a random location
            startups.get(i).setLocation(location);               //pass the location into the startup
        }
        int emptyCount = 0;
        System.out.println("Guess startup location in format (A1-G7)");
        while (emptyCount <3) {
            String result = "miss";
            String userInput = helper.getUserInput();             //get user input
            for (Startup startup : startups) {                    //iterate through each startup
                if (startup.getLocation().contains(userInput)) {  //if the current startup contains userInput
                    startup.getLocation().remove(userInput);      //remove userInput from the ArrayList<String> location
                    result = "hit";
                    if (startup.getLocation().isEmpty()) {
                        System.out.println(startup.getName() + " has been killed!");
                        emptyCount++;
                    }
                }
            }
            System.out.println(result + "! There are currently "+ (3-emptyCount) +" startups remaining");

/* to do - display how many locations left in a startup when it is hit
         - end of game performance review
         - invalid input messages
         - give up option
         - find a way to allow vertical startups to be made and multiple startups on each row?


            for (Startup i : startups) {              //view the positions set for the startups

                 System.out.println(i.getName());
                 System.out.println(i.getLocation());
*/
        }
        System.out.println("you killed all the startups, congrats!\nYour stocks are now worthless");
    }
}


/*     Board format, r=A-G, c =1-7
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