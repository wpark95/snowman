package com.snowman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static String gameMode;
  private static int remainingGuess;
  private static int wordLength;
  private static StringBuilder wordPlaceholder;

  // Snowman Builds
  private static String hatTop = " *       /*\\  *    *";
  private static String hatLow = "   *   _/ _ \\_ *   * ";
  private static String neutralFace = " *   *  (‘< ‘ ) *      *";
  private static String sadFace = " *   *  (T< T ) *      *";
  private static String happyFace = " *   *  (^< ^ ) *      *";
  private static String bodyTop = "   * \\–(  :   )–/   *";
  private static String bodyLow = " *    (__: __)  *    *";

  static String[] fourLength = {"wait", "wake", "walk", "want", "nice"};
  static String[] fiveLengths = {"about", "above", "again", "jelly", "lower"};
  static String[] sixLengths = {"abroad", "accept", "access", "across", "acting"};
  static String[] sevenLengths = {"Ability", "absence", "academy", "account", "accused"};
  static String[][] wordList = {new String[]{}, new String[]{}, new String[]{}, new String[]{},
      fourLength, fiveLengths, sixLengths, sevenLengths};

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
    System.out.println("Hey there! How many guesses do you want?");
    // TODO Range of number of guesses should be within [1 - 30].
    remainingGuess = Integer.parseInt(reader.readLine());
    System.out.println(remainingGuess);
    // TODO Range of word length should be [4-14] using a .csv file.
    System.out.println("How long do you want the word to be?");
    wordLength = Integer.parseInt(reader.readLine());

    System.out.println(wordLength);
    for (String word : wordList[wordLength]) {
      int randomIndex = (int) ((Math.random() * ((wordList[wordLength].length - 1))));
      String secretWord = wordList[wordLength][randomIndex];
      System.out.println(secretWord);
      break;
    }

    wordPlaceholder = new StringBuilder("Your guess so far:");
    for (int i = 0; i < wordLength; i++) {
      wordPlaceholder.append(" _");
    }
    System.out.println("Remaining guesses: " + remainingGuess);
    System.out.println(wordPlaceholder);

    int sadPoint = 3;
    if (remainingGuess > sadPoint) { // Prints out happy snowman
      printHappySnowman();
    } else if (remainingGuess == sadPoint) {
      printSadSnowman();
    } else if (remainingGuess < sadPoint - 2) {
      System.out.println("Good job. You killed the snowman.");
      printHat();
    } else if (remainingGuess < sadPoint - 1) {
      printHat();
      System.out.println(sadFace);
    } else {
      printHat();
      System.out.println(sadFace);
      System.out.println(bodyTop);
    }
  }

  private static void printHappySnowman() {
    printHat();
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void printSadSnowman() {
    printHat();
    System.out.println(sadFace);
    System.out.println(bodyTop);
    System.out.println(bodyLow);
  }

  private static void printHat() {
    System.out.println(hatTop); // TODO: Combine hatTop and hatLow.
    System.out.println(hatLow);
  }

}






