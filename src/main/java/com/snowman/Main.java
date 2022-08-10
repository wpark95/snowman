package com.snowman;

import com.snowman.model.WordProcessor;
import com.snowman.controller.SinglePlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final String BUNDLE_NAME = "strings";
  private static String gameMode;

  public static void main(String[] args) throws IOException {
//    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    WordProcessor words = new WordProcessor();

    System.out.println("Hey there! What would you like to play?");
    System.out.println("Enter 1 for Single-Player");
    System.out.println("Enter 2 for Multi-Player");

    gameMode = reader.readLine();
    if (gameMode.equals("1")) {
      SinglePlayer player = new SinglePlayer();
      player.singlePlayerController(reader, words);
    } else {
      multiPlayer();
    }
  }
  static void multiPlayer() {
    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }

}
