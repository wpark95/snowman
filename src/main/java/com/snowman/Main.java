package com.snowman;

import com.snowman.controller.SinglePlayer;
import com.snowman.model.WordListProcessor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Implements entry point for console-mode implementation of <strong>Snowman</strong> game.
 */
public class Main {

  private static final String BUNDLE_NAME = "strings";
  private static String gameMode; //remove static when can

  /**
   * @param args Command-line arguments.
   * @throws IOException Thrown if an I/O error is produced by failed or interrupted I/O
   *                     operations.
   */
  public static void main(String[] args) throws IOException {
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    WordListProcessor words = new WordListProcessor();
    Random rng = new Random();

    while ((gameMode == null) || !gameMode.equals("2") || !gameMode.equals("1")) {
      gameMode = promptGameMode(reader);
      if (gameMode.equals("1")) {
        SinglePlayer game = new SinglePlayer(reader, words, bundle);
      } else if (gameMode.equals("2")) {
        multiPlayer();
      }
    }
  }

  private static String promptGameMode(BufferedReader reader) throws IOException {
    System.out.println("Hey there! What would you like to play?");
    System.out.println("Enter 1 for Single-Player");
    System.out.println("Enter 2 for Multi-Player");
    return reader.readLine().trim();
  }

  static void multiPlayer() {
    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }
}