package com.company;

import javafx.application.Preloader;

import java.io.IOException;
import java.util.Scanner;

public class MainDialogue {

    public static void runPokeGuesser() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String name;
        intro();

        var one = 1;
        while (one < 2){
            test2 tst = new test2();
            tst.testConn();
            name = tst.getName();
            System.out.println(name);

            one++;


        }



    }

    public static void intro(){
        System.out.println("With that out the way, Welcome to PokeGuesser, and thank you for playing!\n");
        System.out.println("PokeGuesser generates a random Pokémon from PokeAPI and its your job to guess!\n");
        System.out.println("In this initial version of PokeGuesser, you will choose from the original 151 Pokémon!\n");
        System.out.println("In future versions you will be able to choose to include or exclude whatever generation of Pokémon you want!\n");
        System.out.println("Future versions will have a lot more features such as Pokémon sprites, typo detection, and a GUI!\n");
        System.out.println("Until then, enjoy version 1 of PokeGuesser!");

    }

}
