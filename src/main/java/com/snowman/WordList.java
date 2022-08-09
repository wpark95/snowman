package com.snowman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordList {
  public static final String WORD_LIST_FILE = "./src/main/resources/snowman-words-four-to-fifteen.csv";

  public static String wordChoice(int userLength) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File(WORD_LIST_FILE));
    String[] words = new String[0];
    int userChoice = (userLength - 4);
    int randomIndex = 0;
    for (int i = 0; i <= userChoice; i++) {
      String currentLine = scanner.nextLine();
      if (i == userChoice) {
        words = currentLine.split(",");
        randomIndex = (int) ((Math.random() * ((words.length - 1))));
      }
    }
    return words[randomIndex];

  }

}