package com.snowman.view;

import com.snowman.Main;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MessagePrinter {

  private static final String hatTop = "  *      /*\\  *    *";
  private static final String hatLow = "    *  _/ _ \\_ *   * ";
  private static final String neutralFace = " *   * ('< ' ) *      *";
  private static final String sadFace = " *   * (T< T ) *      *";
  private static final String happyFace = " *   * (^< ^ ) *      *";
  private static final String bodyTop = "   * \\–(  :   )–/   *";
  private static final String bodyLow = "   *   (__: __)  *    *";

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
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void printNeutralSnowman() {
    printHat();
    System.out.println(neutralFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void printTopBodyOnlySnowman() {
    printHalfSnowman();
    System.out.println(bodyTop);
  }

  private static void printHalfSnowman() {
    printHat();
    System.out.println(sadFace);
  }

  private static void printHat() {
    System.out.println(hatTop);
    System.out.println(hatLow);
  }

  public static void printWinMessage(String secretWord) { // TODO: Fix Win and Lose Message
    System.out.println("\n"
        + "░█████╗░░█████╗░███╗░░██╗░██████╗░██████╗░░█████╗░████████╗██╗░░░██╗██╗░░░░░░█████╗░████████╗██╗░█████╗░███╗░░██╗░██████╗\n"
        + "██╔══██╗██╔══██╗████╗░██║██╔════╝░██╔══██╗██╔══██╗╚══██╔══╝██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║██╔════╝\n"
        + "██║░░╚═╝██║░░██║██╔██╗██║██║░░██╗░██████╔╝███████║░░░██║░░░██║░░░██║██║░░░░░███████║░░░██║░░░██║██║░░██║██╔██╗██║╚█████╗░\n"
        + "██║░░██╗██║░░██║██║╚████║██║░░╚██╗██╔══██╗██╔══██║░░░██║░░░██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║██║░░██║██║╚████║░╚═══██╗\n"
        + "╚█████╔╝╚█████╔╝██║░╚███║╚██████╔╝██║░░██║██║░░██║░░░██║░░░╚██████╔╝███████╗██║░░██║░░░██║░░░██║╚█████╔╝██║░╚███║██████╔╝\n"
        + "░╚════╝░░╚════╝░╚═╝░░╚══╝░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═════╝░\n"
        + "                                        Congratulations! Your word was: " + secretWord);
  }

  public static void printLoseMessage(String secretWord) {

    System.out.println("\n"
        + "░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░██╗░░░██╗███████╗██████╗░\n"
        + "██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗\n"
        + "██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝\n"
        + "██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗\n"
        + "╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║\n"
        + "░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝\n"
        + "                 Oh no :(   Your word was: " + secretWord);
  }

  public static void printCurrentState(int remainingGuess, String wordPlaceholder,
      Set<String> triedWords) {
    System.out.println("Your remaining guesses: " + remainingGuess);
    System.out.println("You have tried so far: " + triedWords);
    System.out.println("Mystery word : " + wordPlaceholder);
  }

}
