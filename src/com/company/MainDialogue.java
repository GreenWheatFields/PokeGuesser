package com.company;

import java.io.IOException;
import java.util.Scanner;

public class MainDialogue {

    public static void runPokeGuesser() throws IOException {
        int height;
        int weight;
        int id;
        int baseExp;
        int correct = 0;
        int one = 1;

        String name;
        String type1;
        String type2;
        String firstLetter;
        String type2Message;
        String guess;

        double heightInInches;
        double weightInLbs;

        Scanner userInput = new Scanner(System.in);

        intro();

        while (one < 2){

            int tries = 0;
            Stats stats = new Stats();
            stats.testConn(); //try this outside the loop. also addd a test for bublapedia
            System.out.println("Generating random pokemon...");
            name = stats.getName();
            height = stats.getHeight();
            heightInInches = (height * 3.93701);
            weight = stats.getWeight();
            weightInLbs = (weight / 4.536);
            id = stats.getID();
            baseExp = stats.getBaseExperience();
            type1 = stats.getType();
            type2 = stats.getType2();
            firstLetter = String.valueOf(name.charAt(0));
            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }

            System.out.println("This Pokémon's id number is " + id);
            System.out.println("Their height in decimetres is " + height);
            System.out.printf("Which is "+ "%.2f", heightInInches);
            System.out.print(" inches.");
            System.out.println("");
            System.out.println("Their weight in hectograms is " + weight);
            System.out.printf("Which is "+ "%.2f", weightInLbs);
            System.out.print(" pounds");
            System.out.println("");
            System.out.println("The base experience for this Pokemon is " + baseExp);
            System.out.println("This Pokemon is of type " + type1 + type2Message);
            System.out.println("And finally, the first letter of this Pokemon's name is " + firstLetter);
            System.out.println("Good luck, type your guess below. if at anytime you want to reveal the full name type 'reveal'");
            stats = null;
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal")){
                    System.out.println(name);
                }
                tries++;
                System.out.println("incorrect. Tries = " + tries);
                guess = userInput.nextLine();
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("Correct!! it took you " + tries + " tries! You have guessed " + correct + " so far!");
            }
            System.out.println("Get another Pokemon? Y/N");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                one--;
            }
            one++;
        }
    }

    public static void intro(){
        System.out.println("With that out the way, Welcome to PokeGuesser, and thank you for playing!\n");
        System.out.println("PokeGuesser generates a random Pokémon from PokeAPI and its your job to guess!\n");
        System.out.println("In this initial version of PokeGuesser, you will choose from the original 151 Pokémon!\n");
        System.out.println("In future versions you will be able to choose to include or exclude whatever generation of Pokémon you want!\n");
        System.out.println("Future versions will have a lot more features such as Pokémon sprites, typo detection, and a GUI!\n");
        System.out.println("Until then, enjoy version 0.1 of PokeGuesser!");
        System.out.println("To begin press enter. Please wait a second after hitting enter for everything to load");
        Scanner userInput = new Scanner(System.in);
        String next = userInput.nextLine();



    }

}
