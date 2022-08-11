package com.snowman;

import com.snowman.controller.SinglePlayer;
import com.snowman.model.WordProcessor;
import com.snowman.view.PromptMessagePrinter;
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

    while ((gameMode == null) || !gameMode.equals("2") || !gameMode.equals("1")) {
      promptGameMode(reader);
      if (gameMode.equals("1")) {
        SinglePlayer player = new SinglePlayer();
        player.singlePlayerController(reader, words);
      } else if (gameMode.equals("2")) {
        multiPlayer();
      }
    }

  }

  private static void promptGameMode(BufferedReader reader) throws IOException {
    PromptMessagePrinter.promptGameMode();
    gameMode = reader.readLine();

//    System.out.println("Hey there! What would you like to play?");
//    System.out.println("Enter 1 for Single-Player");
//    System.out.println("Enter 2 for Multi-Player");
  }

  static void multiPlayer() {
    PromptMessagePrinter.promptMultiplayer();

//    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }

}
