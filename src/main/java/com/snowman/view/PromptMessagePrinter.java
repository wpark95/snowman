package com.snowman.view;


public class PromptMessagePrinter {
  // TODO: Consolidate user prompt messages into here, so that they can be invoked in individual methods

  public static void promptGameMode() {
    System.out.println("Hey there! What would you like to play?");
    System.out.println("Enter 1 for Single-Player");
    System.out.println("Enter 2 for Multi-Player");
  }

  public static void promptMultiplayer() {
    System.out.println("Sorry, the multiplayer feature is not ready yet.");
  }

  private static void promptGetUserGamePreference() {

  }

//  public static void printGameState() {
//    System.out.println("Already guessed: " + triedWords);
//    System.out.println("Your guess so far: " + wordPlaceholder);
//    System.out.println("Remaining guesses: " + remainingGuess);
//  }

}
