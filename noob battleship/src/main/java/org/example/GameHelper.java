package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    ArrayList<Character> validInputRow = new ArrayList<>(Arrays.asList('A','B','C','D','E','F','G'));
    ArrayList<Character> validInputCol = new ArrayList<>(Arrays.asList('1','2','3','4','5','6','7'));
    ArrayList<String> existingPositions =new ArrayList<>();

    public ArrayList<String> makeLocations() {
        ArrayList<String> location = new ArrayList<>();
        char randomColumn, randomRow;
        Random randomGenerator = new java.util.Random();
        int rand = randomGenerator.nextInt(5);
        int i = 0;
        while (location.size() < 3) {  //creates 3 random locations that are one after the other in a row
            randomRow = validInputRow.get(rand);
            randomColumn = validInputCol.get(rand + i);   //+i to make consecutive locations

            String randomLocation = "" + randomRow + randomColumn;
            if (existingPositions.contains(randomLocation)) {
                rand = randomGenerator.nextInt(5);
                continue;
            }
            if (i == 0) {
                existingPositions.add(randomLocation);
            }
            i++;
            location.add(randomLocation);
        }
        return location;
    }


    public String getUserInput() {
        ArrayList<Character> validInput = new ArrayList<>();
        validInput.addAll(validInputRow);
        validInput.addAll(validInputCol);

        while (true) {
            Scanner locationScanner = new Scanner(System.in);
            String locationGuess = locationScanner.nextLine();
            char locationRow = locationGuess.charAt(0);
            char locationColumn = locationGuess.charAt(1);
            if (validInput.contains(locationRow) && (validInput.contains(locationColumn))) {
                return locationGuess;
            }
        }
    }
}
