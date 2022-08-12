package com.snowman;

import com.snowman.controller.SinglePlayer;
import com.snowman.model.WordListProcessor;
import com.snowman.view.MessagePrinter;
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
    MessagePrinter.printWelcomeMessage();
    ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
    WordListProcessor words = new WordListProcessor();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ) {
      do {
        gameMode = promptGameMode(reader);
        if (gameMode.equals("1")) {
          new SinglePlayer(reader, words, bundle);
        } else if (gameMode.equals("2")) {
          multiPlayer();
        } else if (gameMode.equals("3")) {
          break;
        }
      } while (true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String promptGameMode(BufferedReader reader) throws IOException {
    System.out.println("Hey there! What would you like to play?");
    System.out.println("Enter 1 for Single-Player");
    System.out.println("Enter 2 for Multi-Player");
    System.out.println("Enter 3 to Exit Snowman");
    return reader.readLine().trim();
  }

  static void multiPlayer() {
    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }

}