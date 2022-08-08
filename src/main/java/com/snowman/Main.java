package com.snowman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static String gameMode;
  private static int numberOfGuesses;
  private static int userLength;


  static String[] fourLength = {"wait", "wake", "walk", "want", "nice"};
  static String[] sixLengths = {"abroad", "accept", "access", "across", "acting"};
  static String[] fiveLengths = {"about", "above", "again", "jelly", "lower"};
  static String[] sevenLengths = {"Ability", "absence", "academy", "account", "accused"};
  static String[][] wordList = {new String[]{}, new String[]{}, new String[]{}, new String[]{},
      fourLength, fiveLengths, sixLengths, sevenLengths};


  private static String secretWord;

  public static void main(String[] args) throws IOException {

    Reader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    System.out.println("Hey there! What would you like to play?");
    System.out.println("1 - Single-Player");
    System.out.println("2 - Multi-Player");

    gameMode = reader.readLine();
    if (gameMode.equals("1")) {
      singlePlayer(reader);
    } else {
      multiPlayer();
    }
  }

  static void multiPlayer() {
    System.out.println("You are wrong, lol.");
  }

  static void singlePlayer(BufferedReader reader) throws IOException {
    System.out.println("You are right.");
    System.out.println("Hey there! How many guesses do you want?");
    numberOfGuesses = Integer.parseInt(reader.readLine());
    System.out.println(numberOfGuesses);
    System.out.println("How long do you want the word to be?");
    userLength = Integer.parseInt(reader.readLine());
    // TODO Range of word length (4-14)

    System.out.println(userLength);
    for (String word : wordList[userLength]) {
      int randomIndex = (int) ((Math.random() * ((wordList[userLength].length - 1) - 0)) + 0);
      secretWord = wordList[userLength][randomIndex];
      System.out.println(secretWord);
      break;


    }


  }


}






