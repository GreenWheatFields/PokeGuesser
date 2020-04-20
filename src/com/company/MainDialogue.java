package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class MainDialogue {
    int height;
    int weight;
    int id;
    int baseExp;
    int correct = 0;
    int one =1;
    int easy = 3;
    int medium = 3;
    int hard = 3;
    int x;

    String name;
    String type1;
    String type2;
    String firstLetter;
    String type2Message;
    String guess;
    String pokeDesc;
    String detailedSprite; //url
    String frontSprite;
    String backSprite;
    String firstGens;
    String mode;


    double heightInInches;
    double weightInLbs;

    DecimalFormat df2 = new DecimalFormat("#.##");
    Scanner userInput = new Scanner(System.in);



    public void runPokeGuesser() throws IOException {

        Stats stat = new Stats();
        //stat.testConn();
        stat = null;
        intro();
        mode = userInput.nextLine().toLowerCase();
        x = 1;
        while (x != 2) {
            switch (mode) {
                case "easy":
                    easy = 1;
                    x = 2;
                    easyMode(easy);
                    break;
                case "medium":
                    x =2;
                    medium = 1;
                    mediumMode(medium);
                    break;
                case "hard":
                    x =2;
                    hard = 1;
                    hardMode(hard);
                    break;
                default:
                    System.out.println("Please select a mode: Easy, Medium , or Hard");
                    mode = userInput.nextLine();
                    if (mode.equalsIgnoreCase("medium")){
                        medium = 1;
                        mediumMode(medium);
                    }else if (mode.equalsIgnoreCase("easy")){
                        easy =1;
                        easyMode(easy);
                    }else if (mode.equalsIgnoreCase("hard")){
                        hard = 1;
                        hardMode(hard);
                    }else {
                        System.out.println("Please select a mode: Easy, Medium , or Hard");
                        mode = userInput.nextLine();
                    }
            }
        }
    }

    public void easyMode(int easy) throws IOException{
        while (easy < 2){
            int tries = 0;
            Stats stats = new Stats();
            System.out.println("Generating random pokemon on Easy Mode...");
            // int r = stats.randomPoke; randomPoke matches the id, does not return null. perhaps r could be added to an array, idk.
            name = stats.getName();
            height = stats.getHeight();
            heightInInches = (height * 3.93701);
            weight = stats.getWeight();
            weightInLbs = (weight / 4.536);
            id = stats.getID();
            baseExp = stats.getBaseExperience();
            type1 = stats.getType();
            type2 = stats.getType2();
            firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
            pokeDesc = stats.getPokeDesc(8);
            detailedSprite = stats.getDetailedSprite();
            frontSprite = stats.getFrontSprite();
            backSprite = stats.getBackSprite();
            firstGens = stats.getFirstGens();

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nFirst Appearance:" + firstGens) + ("\nType:" + type1 + type2Message) +
                    ("\nFirst Letter: " + firstLetter) + ("\nHeight: " + df2.format(heightInInches) + " inches") + ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'\n") + ("\nIn game sprites")// i want to display detailed sprites for easy mode, but because detailed sprite urls contain the name, i cant right now
                    + ("\nFront: " + frontSprite) + ("\nBack: " + backSprite) + ("\nType your guess below. \nTo reveal the full name type 'reveal'"));
            System.out.println(message);
            stats = null;
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal")){
                    System.out.println(name);
                }
                tries++;
                System.out.println("Incorrect. Tries: " + tries);
                guess = userInput.nextLine();
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("Correct, it took you " + tries + " tries. You have guessed " + correct + " so far.");
            }
            System.out.println("Get another Pokemon? Y/N");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                easy--;
            }else{
                System.out.println("Thank you for playing!");
            }
            easy++;
        }


    }


    public void mediumMode(int medium) throws IOException{

        while (medium < 2){            // 2 , 4 , 6
            int tries = 0;
            Stats stats = new Stats();
            System.out.println("Generating random pokemon on Medium Mode...");
            // int r = stats.randomPoke; randomPoke matches the id, does not return null. perhaps r could be added to an array, idk.
            name = stats.getName();
            height = stats.getHeight();
            heightInInches = (height * 3.93701);
            weight = stats.getWeight();
            weightInLbs = (weight / 4.536);
            id = stats.getID();
            baseExp = stats.getBaseExperience();
            type1 = stats.getType();
            type2 = stats.getType2();
            firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
            pokeDesc = stats.getPokeDesc(4);
            detailedSprite = stats.getDetailedSprite();
            frontSprite = stats.getFrontSprite();
            backSprite = stats.getBackSprite();
            firstGens = stats.getFirstGens();

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nFirst Appearance:" + firstGens) + ("\nType:" + type1 + type2Message) +
                    ("\nFirst Letter: " + firstLetter) + ("\nHeight: " + df2.format(heightInInches) + " inches") + ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'\n") + ("\nIn game sprites")
                    + ("\nFront: " + frontSprite) + ("\nBack: " + backSprite) + ("\nType your guess below. \nTo reveal the full name type 'reveal'"));
            System.out.println(message);
            stats = null;
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)){
                if (guess.equalsIgnoreCase("reveal")){
                    System.out.println(name);
                }
                tries++;
                System.out.println("Incorrect. Tries: " + tries);
                guess = userInput.nextLine();
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("Correct, it took you " + tries + " tries. You have guessed " + correct + " so far.");
            }
            System.out.println("Get another Pokemon? Y/N");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                medium--;
            }else{
                System.out.println("Thank you for playing!");
            }
            medium++;
        }


    }


    public void hardMode(int hard) throws IOException {
        while (hard < 2){
            int tries = 0;
            Stats stats = new Stats();
            System.out.println("Generating random pokemon on Hard Mode...");
            // int r = stats.randomPoke; randomPoke matches the id, does not return null. perhaps r could be added to an array, idk.
            name = stats.getName();
            height = stats.getHeight();
            heightInInches = (height * 3.93701);
            weight = stats.getWeight();
            weightInLbs = (weight / 4.536);
            id = stats.getID();
            baseExp = stats.getBaseExperience();
            type1 = stats.getType();
            type2 = stats.getType2();
            firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
            pokeDesc = stats.getPokeDesc(3);
            detailedSprite = stats.getDetailedSprite();
            frontSprite = stats.getFrontSprite();
            backSprite = stats.getBackSprite();
            firstGens = stats.getFirstGens();

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nFirst Appearance:" + firstGens) + ("\nType:" + type1 + type2Message) +
                    ("\nHeight: " + df2.format(heightInInches) + " inches") + ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'\n") + ("\nIn game sprites")
                    + ("\nFront: " + frontSprite) + ("\nBack: " + backSprite) + ("\nType your guess below. \nTo reveal the full name type 'reveal'"));
            System.out.println(message);
            stats = null;
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal")){
                    System.out.println(name);
                }
                tries++;
                System.out.println("Incorrect. Tries: " + tries);
                guess = userInput.nextLine();
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("Correct, it took you " + tries + " tries. You have guessed " + correct + " so far.");
            }
            System.out.println("Get another Pokemon? Y/N");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                hard--;
            }/*else if (replay.equalsIgnoreCase("q")){
                //runPokeGuesser(); will come back to this later
            }*/else{
                System.out.println("Thank you for playing!");
            }
            hard++;
        }
    }








    public static void intro(){
        String introMessage = (("Welcome to PokeGuesser!\n") + ("\nPokeGuesser generates a random Pokémon id # then gets that Pokemon's data from PokeApi and Bulbapedia\n")
                + ("\nFor now, you will choose from the original 151 Pokémon.\n")
                + ("\nIn future versions you will be able to choose to include or exclude whatever generation of Pokémon you want.\n")
                +("\nThis game has three modes, Easy, Medium, and Hard\n")
                +("\nEasy Mode will show everything available about a Pokemon, including a detailed picture, you can type 'reveal' but only the reveal the first letter\n")//maybe have each 'reveal' reveal another letter of the pokemons name
                +("\nMedium Mode has less data than Easy. The picture shown in Medium mode is an in game pixelated sprite, you can still type 'reveal', but it will count toward your tries\n")
                + ("\nHard Mode is for people with extensive knowledge, You will have minimal information and you wont be able to reveal the Pokemon or see a picture\n")
                + ("\n To play, type your mode 'Easy', 'Medium', or 'Hard'  and press Enter, allow a moment for pokemon to load."));

        System.out.println(introMessage);

    }

}
