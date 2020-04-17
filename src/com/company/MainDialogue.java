package com.company;

import com.sun.jdi.Value;
import javafx.application.Preloader;

import java.io.IOException;
import java.util.Scanner;

public class MainDialogue {

    public static void runPokeGuesser() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String name;
        int height;
        int weight;
        int id;
        int baseExp;
        String type1;
        String type2;
        String firstLetter;
        double heightInInches;
        double weightInLbs;
        String type2Message;
        String guess;
        int revealName;
        String pokeDesc;

        int correct = 0;
        //intro();


        var one = 1;
        while (one < 2){
            int tries = 0;
            test2 tst = new test2();
            jsoupExperimenting js = new jsoupExperimenting();
            //tst.testConn();
            System.out.println("Generating random pokemon...");
            name = tst.getName();
            height = tst.getHeight();
            heightInInches = (height * 3.93701);
            weight = tst.getWeight();
            weightInLbs = (weight / 4.536);
            id = tst.getID();
            baseExp = tst.getBaseExperience();
            type1 = tst.getType();
            type2 = tst.getType2();
            pokeDesc = js.getPokeDesc();
            System.out.println(name + pokeDesc + "aaaaaaaaaaaa");


            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            firstLetter = String.valueOf(name.charAt(0));
           /* System.out.println("This Pokémon's id number is " + id);
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
            tst = null;
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

*/
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
