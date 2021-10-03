package com.company.views;

import java.util.Scanner;

public class CmdLineView {

    private final String[] letters;


    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    public String makeAGuess(){
        System.out.print("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void displayHints(String[] hints){
        for(String hint: hints){
            System.out.print(hint);
        }
        System.out.print("\n");
    }

    //I took out some unused getters and setters that intelliJ didn't like,
    //but I am keeping this in just in case
    public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
     }

    public void victory(){
        System.out.println("You've Won!");
    }

    public void defeat(String[] letters){
        System.out.println("You lose, Better luck Next Time!");
        System.out.print("The Word was ");
        for (String letter : letters) {
            System.out.print(letter);
        }
    }

    public void wrongGuess(String guess, int numGuess){
        System.out.println(guess + " was incorrect");
        System.out.println("Guesses Remaining: "+numGuess+"\n");
    }

}

