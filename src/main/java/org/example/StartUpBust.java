package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class StartUpBust {
    public static ArrayList<Startup> setUpGame(String[] names, GameHelper helper) {
        ArrayList<Startup> startups = new ArrayList<>();        //initialise startups arraylist
        for (int i = 0; i < 3; i++) {                           //create 3 startups
            startups.add(new Startup(names[i]));
            ArrayList<String> location = helper.makeLocations(); //get helper to generate a random location
            startups.get(i).setLocation(location);               //pass the location into the startup
        }
        return startups;
    }

    public static Object[] startPlaying(int numOfGuesses, int emptyCount, GameHelper helper, ArrayList<Startup> startups) {
        System.out.println("Guess startup location in format (A1-G7)");
        while (emptyCount < 3) {
            String userInput = helper.getUserInput();                           //get user input
            String[] resultArr = checkUserInput(userInput, emptyCount, startups);
            String result = resultArr[0];
            emptyCount = Integer.parseInt(resultArr[1]);

            System.out.println(result + "! There are currently " + (3 - emptyCount) + " startups remaining");
            numOfGuesses++;
        }
        return new Object[]{true, numOfGuesses};
    }

    public static String[] checkUserInput(String userInput, int emptyCount, ArrayList<Startup> startups) {
        String result = "miss";
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
        return new String[]{result, String.valueOf(emptyCount)};
    }

    public static void main(String[] args) {
        String[] names = {"rapidkl", "shopee", "remitly"};
        int numOfGuesses = 0;
        int emptyCount = 0;
        GameHelper helper = new GameHelper();                           //initialise helper
        ArrayList<Startup> startups = setUpGame(names, helper);         //creates the startups & calls helper to create random locations
        Object[] end = startPlaying(numOfGuesses, emptyCount, helper, startups); //starts the game, loop till success or forfeit. calls checkUserInput
        boolean fin = (boolean) end[0];
        numOfGuesses = (int) end[1];
        if (fin) {          //fin represents the outcome, whether user won or forfeited
            System.out.println("you killed all the startups, in " + numOfGuesses + " guesses! congrats!\nYour stocks are now worthless");

        } else {
            System.out.println("better luck next time :(");
        }
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