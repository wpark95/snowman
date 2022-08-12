package com.snowman.view;

import java.util.Set;

public class MessagePrinter {

  public static final String WIN_MESSAGE =
      "░█████╗░░█████╗░███╗░░██╗░██████╗░██████╗░░█████╗░████████╗██╗░░░██╗██╗░░░░░░█████╗░████████╗██╗░█████╗░███╗░░██╗░██████╗\n"
          + "██╔══██╗██╔══██╗████╗░██║██╔════╝░██╔══██╗██╔══██╗╚══██╔══╝██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║██╔════╝\n"
          + "██║░░╚═╝██║░░██║██╔██╗██║██║░░██╗░██████╔╝███████║░░░██║░░░██║░░░██║██║░░░░░███████║░░░██║░░░██║██║░░██║██╔██╗██║╚█████╗░\n"
          + "██║░░██╗██║░░██║██║╚████║██║░░╚██╗██╔══██╗██╔══██║░░░██║░░░██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║██║░░██║██║╚████║░╚═══██╗\n"
          + "╚█████╔╝╚█████╔╝██║░╚███║╚██████╔╝██║░░██║██║░░██║░░░██║░░░╚██████╔╝███████╗██║░░██║░░░██║░░░██║╚█████╔╝██║░╚███║██████╔╝\n"
          + "░╚════╝░░╚════╝░╚═╝░░╚══╝░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═════╝░\n"
          + "                                        Congratulations! Your word was: ";
  public static final String LOSE_MESSAGE =
      "░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░██╗░░░██╗███████╗██████╗░\n"
          + "██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗\n"
          + "██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝\n"
          + "██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗\n"
          + "╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║\n"
          + "░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝\n"
          + "                 Oh no :(   Your word was: ";

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String HAT_TOP = "  *      " + ANSI_GREEN + "/*\\" + ANSI_RESET + "*    *";
  public static final String HAT_LOW = "    *" + ANSI_GREEN + "  _/ _ \\_" + ANSI_RESET + "*   * ";
  public static final String NEUTRAL_FACE = " *   *  ('" + ANSI_RED + "<" + ANSI_RESET + "' ) *      *";
  public static final String SAD_FACE = " *   *  (T" + ANSI_RED + "<" + ANSI_RESET + "T ) *      *";
  public static final String HAPPY_FACE = " *   *  (^" + ANSI_RED + "<" + ANSI_RESET + "^ ) *      *";
  public static final String BODY_TOP = "    * \\–( :   )–/   *";
  public static final String BODY_LOW = "  *  * (__: __)  *    *";
  public static final String WELCOME = "\n"
      + "░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗\n"
      + "░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝\n"
      + "░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░\n"
      + "░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░\n"
      + "░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗\n"
      + "░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝";
  public static final String TO = "\n"
      + "                        ████████╗░█████╗░\n"
      + "                        ╚══██╔══╝██╔══██╗\n"
      + "                        ░░░██║░░░██║░░██║\n"
      + "                        ░░░██║░░░██║░░██║\n"
      + "                        ░░░██║░░░╚█████╔╝\n"
      + "                        ░░░╚═╝░░░░╚════╝░";
  public static final String SNOWMAN = "\n"
      + "░██████╗███╗░░██╗░█████╗░░██╗░░░░░░░██╗███╗░░░███╗░█████╗░███╗░░██╗\n"
      + "██╔════╝████╗░██║██╔══██╗░██║░░██╗░░██║████╗░████║██╔══██╗████╗░██║\n"
      + "╚█████╗░██╔██╗██║██║░░██║░╚██╗████╗██╔╝██╔████╔██║███████║██╔██╗██║\n"
      + "░╚═══██╗██║╚████║██║░░██║░░████╔═████║░██║╚██╔╝██║██╔══██║██║╚████║\n"
      + "██████╔╝██║░╚███║╚█████╔╝░░╚██╔╝░╚██╔╝░██║░╚═╝░██║██║░░██║██║░╚███║\n"
      + "╚═════╝░╚═╝░░╚══╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝";

  public static void printSnowman(int remainingGuess, String secretWord) {
    switch (remainingGuess) {
      case 0:
        MessagePrinter.printLoseMessage(secretWord);
        break;
      case 1:
        MessagePrinter.printHalfSnowman();
        break;
      case 2:
        MessagePrinter.printTopBodyOnlySnowman();
        break;
      case 3:
        MessagePrinter.printNeutralSnowman();
        break;
      default:
        MessagePrinter.printHappySnowman();
        break;
    }
  }

  private static void printHappySnowman() {
    printHat();
    System.out.println(HAPPY_FACE);
    System.out.println(BODY_TOP); // TODO: Fix redundancy in printing the snowman.
    System.out.println(BODY_LOW);
  }

  private static void printNeutralSnowman() {
    printHat();
    System.out.println(NEUTRAL_FACE);
    System.out.println(BODY_TOP); // TODO: Fix redundancy in printing the snowman.
    System.out.println(BODY_LOW);
  }

  private static void printTopBodyOnlySnowman() {
    printHalfSnowman();
    System.out.println(BODY_TOP);
  }

  private static void printHalfSnowman() {
    printHat();
    System.out.println(SAD_FACE);
  }

  private static void printHat() {
    System.out.println(HAT_TOP);
    System.out.println(HAT_LOW);
  }

  public static void printWinMessage(String secretWord) { // TODO: Fix Win and Lose Message
    System.out.println(WIN_MESSAGE + secretWord);
  }

  public static void printLoseMessage(String secretWord) {
    System.out.println(LOSE_MESSAGE + secretWord);
  }

  public static void printCurrentState(int remainingGuess, String wordPlaceholder,
      Set<String> triedWords) {
    System.out.println("Your remaining guesses: " + remainingGuess);
    System.out.println("You have tried so far: " + triedWords);
    System.out.println("Mystery word : " + wordPlaceholder);
  }

  public static void printWelcomeMessage () {
    System.out.println(WELCOME);
    System.out.println(TO);
    System.out.println(SNOWMAN);
  }

}