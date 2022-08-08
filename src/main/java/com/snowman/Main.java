package com.snowman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  private static String response;

  public static void main(String[] args) throws IOException {

    Reader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    System.out.println("Hey there! What would you like to play?");
    System.out.println("1 - Single-Player");
    System.out.println("2 - Multi-Player");

    response = reader.readLine();
    System.out.println(response);
    if (response.equals("1")) {
      singlePlayer();
    } else {
      multiPlayer();
    }
  }

  static void multiPlayer() {
    System.out.println("You are wrong, lol.");
  }

  static void singlePlayer() {
    System.out.println("You are right.");
  }

}
