package com.company.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetWord {

    private String theWord;

    public GetWord() {

        try {
            Path thePath = Paths.get("src/" + "wordlist.txt");

            BufferedReader in = new BufferedReader(new FileReader(String.valueOf(thePath)));

            List<String> lines = new ArrayList<>();

            String line;

            try{
                line = in.readLine();

                while(line != null){
                    lines.add(line);
                    line = in.readLine();
                }

                in.close();

                String[] words = lines.toArray(new String[0]);

                theWord = getRandomWord(words);

            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getTheWord() {
        return theWord;
    }

    private String getRandomWord(String[] words){
        int rand = new Random().nextInt(words.length);
        return words[rand];
    }


}
