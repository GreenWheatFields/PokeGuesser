package com.company;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class MainDialogue{
    int height;
    int weight;
    int id;
    int baseExp;
    int correct = 0;
    int easy = 3;
    int medium = 3;
    int hard = 3;
    int x;
    private static int upperBound;
    private static int  lowerBound;
    public static int randomPoke;
    private static int size;

    String name;
    String type1;
    String type2;
    String firstLetter;
    String type2Message;
    String guess;
    String pokeDesc;
    String detailedSprite; //url
    String frontSprite;
    //String backSprite;
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
            name = name.substring(0,1).toUpperCase() + name.substring(1);
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
            firstGens = stats.getFirstGens();
            int reveals = 0;
            int hints = 0;
            System.out.println(stats.lulw.length);

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nFirst Appearance:" + firstGens) + ("\nType: " + type1 + type2Message) +
                    ("\nFirst Letter: " + firstLetter) + ("\nHeight: " + df2.format(heightInInches) + " inches") + ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'\n") + ("\nDetailed Sprite: ")// i want to display detailed sprites for easy mode, but because detailed sprite urls contain the name, i cant right now
                    + detailedSprite + ("\nType your guess below. \nTo reveal the full name type 'reveal'"));
            System.out.println(message);
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal") && reveals <= 1){
                    if (reveals == 0) {
                        tries++;
                        System.out.println("Tries: " + tries);
                        System.out.println("Name: " + name);
                        reveals++;
                        hints++;
                    } else {
                        reveals = 1;
                        System.out.println("It's literally " + name + " what other hint could there be?");
                    }
                    guess = userInput.nextLine();
                }
                if (!guess.equalsIgnoreCase(name) && !guess.equalsIgnoreCase("reveal")){
                    tries++;
                    System.out.println("Incorrect. Tries: " + tries);
                    guess = userInput.nextLine();
                }

            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("CORRECT '" + name + "'. it took you " + tries + " tries and " + hints +  " hints. You have guessed " + correct + " so far.");
            }
            System.out.println("Get new Pokemon: 'Y'\n" + "Reset with same difficulty: 'R' \n" + "Reset with new difficulty: 'A'\n" + "Quit: 'N'");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                easy--;
            }else if(replay.equalsIgnoreCase("R")){
                easyMode(1);
            }else if (replay.equalsIgnoreCase("A")){
                runPokeGuesser();
            }
            else {
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
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            height = stats.getHeight();
            heightInInches = (height * 3.93701);
            weight = stats.getWeight();
            weightInLbs = (weight / 4.536);
            id = stats.getID();
            baseExp = stats.getBaseExperience();
            type1 = stats.getType();
            type2 = stats.getType2();
            firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
            String firstThreeChars;
            if (name.length() >= 3) {
                firstThreeChars = name.substring(0, 4);
            }
            else {
                firstThreeChars = name;
            }
            pokeDesc = stats.getPokeDesc(4);
            String longerDesc = stats.getPokeDesc(8);
            detailedSprite = stats.getDetailedSprite();
            frontSprite = stats.getFrontSprite();
            firstGens = stats.getFirstGens();
            int reveals = 0;
            int hints = 0;

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nFirst Appearance: " + firstGens) + ("\nType: " + type1 + type2Message) +
                    ("\nHeight: " + df2.format(heightInInches) + " inches") + ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'") + ("\nIn game sprite")
                    + ("\nFront: " + frontSprite) + ("\nType your guess below. \nTo reveal hints type 'reveal'. You have four hints"));
            System.out.println(message);

            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal") && reveals <= 4){
                    switch (reveals){
                        case 0:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("First Letter: " + firstLetter);
                            reveals ++;
                            hints++;
                            guess = userInput.nextLine();
                            break;
                        case 1:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("First Three Letter : " + firstThreeChars);
                            reveals++;
                            hints++;
                            guess = userInput.nextLine();

                            break;
                        case 2:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("Longer description " +  longerDesc);
                            reveals++;
                            hints++;
                            guess = userInput.nextLine();
                            break;


                        case 3:
                            reveals++;
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("Detailed Sprite : " + detailedSprite);

                            hints++;
                            guess = userInput.nextLine();
                            break;

                        default:
                            reveals = 4;
                            System.out.println("You are out of hints");
                            guess = userInput.nextLine();

                            break;
                    }
                }
                if (!guess.equalsIgnoreCase(name) && !guess.equalsIgnoreCase("reveal")){
                    tries++;
                    System.out.println("Incorrect. Tries: " + tries);
                    guess = userInput.nextLine();
                }
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("CORRECT. '" + name + "' it took you " + tries + " tries and " + hints +  " hints. You have guessed " + correct + " so far.");
            }
            System.out.println("Get new Pokemon: 'Y'\n" + "Reset with same difficulty: 'R' \n" + "Reset with new difficulty: 'A'\n" + "Quit: 'N'");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                medium--;
            }else if(replay.equalsIgnoreCase("R")){
                mediumMode(1);
            }else if (replay.equalsIgnoreCase("A")){
                runPokeGuesser();
            }
            else {
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
            name = name.substring(0,1).toUpperCase() + name.substring(1);
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
            String longerDesc = stats.getPokeDesc(5);
            detailedSprite = stats.getDetailedSprite();
            frontSprite = stats.getFrontSprite();
            firstGens = stats.getFirstGens();
            int reveals = 0;
            int hints = 0;

            if (type2 == null){
                type2 = "";
                type2Message = "";
            }else{
                type2Message = " and " + type2;
            }
            String message = (("ID number: " + id) + ("\nType: " + type1 + type2Message) +
                    ("\nWeight: " + df2.format(weightInLbs) + " pounds")
                    + ("\nSome lines from Bulbapedia: \n" + "'"  + pokeDesc + "'\n") //blacked out detailed picture
                    + ("\nType your guess below. \nTo reveal a random stat type 'reveal'"));//i only want reveal to be able to be pressed a certain amount of times
            System.out.println(message);
            guess = userInput.nextLine();
            while (!guess.equalsIgnoreCase(name)) {
                if (guess.equalsIgnoreCase("reveal") && reveals <= 3){
                    switch (reveals){
                        case 0:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("First Letter: " + firstLetter);
                            reveals ++;
                            hints++;
                            guess = userInput.nextLine();
                            break;
                        case 1:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("Base Experience: " + baseExp);
                            reveals++;
                            hints++;
                            guess = userInput.nextLine();

                            break;
                        case 2:
                            tries++;
                            System.out.println("Tries: " + tries);
                            System.out.println("Longer description " +  longerDesc);
                            reveals++;
                            hints++;
                            guess = userInput.nextLine();
                            break;
                        default:
                            reveals = 3;
                            System.out.println("You are out of hints");
                            guess = userInput.nextLine();

                            break;
                    }
                }
                if (!guess.equalsIgnoreCase(name) && !guess.equalsIgnoreCase("reveal")){
                    tries++;
                    System.out.println("Incorrect. Tries: " + tries);
                    guess = userInput.nextLine();
                }
            }
            if (guess.equalsIgnoreCase(name)){
                correct++;
                System.out.println("CORRECT. '" + name  + "' it took you " + tries + " tries and " + hints +  " hints. You have guessed " + correct + " so far.");
            }
            System.out.println("Get new Pokemon: 'Y'\n" + "Reset with same difficulty: 'R' \n" + "Reset with new difficulty: 'A'\n" + "Quit: 'N'");
            String replay = userInput.nextLine();
            if (replay.equalsIgnoreCase("Y")){
                hard--;
            }else if(replay.equalsIgnoreCase("R")){
                hardMode(1);
            }else if (replay.equalsIgnoreCase("A")){
                runPokeGuesser();
            }
               else {
                System.out.println("Thank you for playing!");
            }
            hard++;
        }
    }

    public int getRandomPoke(){
        System.out.println("Select Generation:\n" + "1-7\n" + "EX: 'Gen 4'");
        String z = userInput.nextLine().toLowerCase();


        switch (z){
            case "gen 1":
                upperBound = 151;
                lowerBound = 1;
                break;
            case "gen 2":
                upperBound = 251;
                lowerBound = 152;
                break;
            case "gen 3":
                upperBound = 386;
                lowerBound = 252;
                break;
            case "gen 4":
                upperBound = 493;
                lowerBound= 387;
                break;
            case "gen 5":
                upperBound = 649;
                lowerBound = 494;
                break;
            case "gen 6":
                upperBound = 721;
                lowerBound = 650;
                break;
            case "gen 7":
                upperBound = 807;
                lowerBound = 722;
                break;
        }

        int[]select = new int[upperBound - lowerBound];
        for (int i = lowerBound; i < upperBound; i++) {
            select[i - lowerBound] = i;
        }
        System.out.println(select[0]);
        //randomPoke = ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
        size = upperBound - lowerBound +1;//maybe fill the array within the boun
        return randomPoke;
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

