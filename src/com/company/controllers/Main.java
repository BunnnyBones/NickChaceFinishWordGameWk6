package com.company.controllers;

import com.company.models.WordList;
import com.company.views.CmdLineView;

public class Main {

    public static String[] letters;
    public static int numLetters = 0;
    public static int numGuesses;
    public static String theGuess;
    public static String[] hints;
    public static  CmdLineView view;


    public static void main(String[] args) {

        numGuesses = 6;

        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();

        WordList word = new WordList(theWord);

        //WordList word = new WordList(getWord.getTheWord());

        letters = calculateLetters(word.getTheWord());

        hints = new String[letters.length];

        view = new CmdLineView(letters);
        view.startGame();
        //view.cheat(word.getTheWord());

        while(true){
            hints = guess();
            view.displayHints(hints);


               boolean doStringsMatch = false;
               for(int i=0;i<numLetters;i++){
                   if(hints[i].equals(letters[i])){
                       doStringsMatch = true;
                   } else{
                       doStringsMatch = false;
                       break;
                   }
               }

              if(numGuesses < 1 || doStringsMatch){
                if(numGuesses > 0){
                    view.victory();
                } else {
                    view.defeat(letters);
                }
                break;
              }
        }
    }

    private static String[] calculateLetters(String theWord){
        String[] letters = theWord.split("");
        numLetters = letters.length;
        return letters;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static String[] guess(){

        theGuess = view.makeAGuess();

        boolean catchWrongGuess = true;

        for(int i = 0; i < letters.length; i++){
            if(letters[i].equals(theGuess)){
                hints[i] = theGuess;
                catchWrongGuess = false;
            }
            //This is easier to read than " !Object.equals(hints[i], b: "_") "
            //which IntelliJ suggests, plus it works both ways
            else if(hints[i] != "_" && hints[i] != null){
                //No change, keep already guessed letters
                //IntelliJ says this is an error, but I need it
            }
            else {
                hints[i] = "_";
            }
        }

        if(catchWrongGuess){
            numGuesses--;
            view.wrongGuess(theGuess, numGuesses);
        }

        return hints;
    }
}
