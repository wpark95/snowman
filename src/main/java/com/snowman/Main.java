package com.snowman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static String gameMode;
  private static int numberOfGuesses;
  private static int length;

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
    length = Integer.parseInt(reader.readLine());
    System.out.println(length);

  }


}
