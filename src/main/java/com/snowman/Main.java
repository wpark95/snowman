package com.snowman;

import com.snowman.singleplayer.SinglePlayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static String gameMode;

  public static void main(String[] args) throws IOException {

    Reader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    System.out.println("Hey there! What would you like to play?");
    System.out.println("1 - Single-Player");
    System.out.println("2 - Multi-Player");

    gameMode = reader.readLine();
    if (gameMode.equals("1")) {
      SinglePlayer.singlePlayerMain(reader);
    } else {
      multiPlayer();
    }

  }

  static void multiPlayer() {
    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }

}
