package com.snowman.singleplayer;

import java.io.BufferedReader;
import java.io.IOException;

public class SinglePlayer {

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

  public static void singlePlayerMain(BufferedReader reader) throws IOException {
    getUserGamePreference(reader);
    // TODO: This is for functionality demonstration.
    //  Please modify the following for loop to accommodate the use .csv files.

    String[] targetArray = wordList[wordLength];
    int randomIndex = (int) ((Math.random() * ((targetArray.length - 1))));
    String secretWord = targetArray[randomIndex];
    System.out.println(secretWord);
    int sadPoint = 3; // TODO: Make sad point more flexible, not a fixed number.
    while (remainingGuess > 0) {
      printGameState();
      printSnowman(sadPoint); // TODO: Extract printSnowman as a class later, so that it
                              //  can be used in the multiplayer mode.
      System.out.println("Any guess?");
      String userGuess = reader.readLine().trim();
      if (userGuess.length() == 1) { // If the user is guessing for a letter
        if (secretWord.contains(userGuess)) { // And if the user correctly guessed a letter in the secret word
          int charIndex = secretWord.indexOf(userGuess);
          System.out.println(charIndex); // TODO: Delete this.
        } else {
          System.out.println("Damn bro I'm melting!");
          remainingGuess--;
        }
       } else { // If the user is guessing for the secret word
        boolean result = userGuess.equals(secretWord);
      }
    }
  }

  private static void printSnowman(int sadPoint) {
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

  private static void printGameState() {
    wordPlaceholder = new StringBuilder("Your guess so far: ");
    for (int i = 0; i < wordLength; i++) {
      wordPlaceholder.append("_");
    }
    System.out.println("Remaining guesses: " + remainingGuess);
    System.out.println(wordPlaceholder);
  }

  private static void getUserGamePreference(BufferedReader reader) throws IOException {
    System.out.println("Hey there! How many guesses do you want?");
    // TODO Range of number of guesses should be within [1 - 30].
    remainingGuess = Integer.parseInt(reader.readLine());
    System.out.println(remainingGuess);
    // TODO Range of word length should be [4-14] using a .csv file.
    System.out.println("How long do you want the word to be?");
    wordLength = Integer.parseInt(reader.readLine());
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
