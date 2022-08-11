package com.snowman.view;

import com.snowman.Main;
import java.io.IOException;
<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
=======
import java.util.HashSet;
import java.util.Set;
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java

public class MessagePrinter {

  private static final String hatTop = "  *      /*\\  *    *";

  private static final String hatLow = "    *  _/ _ \\_ *   * ";

  private static final String neutralFace = " *   * ('< ' ) *      *";

  private static final String sadFace = " *   * (T< T ) *      *";

  private static final String happyFace = " *   * (^< ^ ) *      *";

  private static final String bodyTop = "   * \\–(  :   )–/   *";

  private static final String bodyLow = "   *   (__: __)  *    *";

  public static void printSnowman(int remainingGuess) throws IOException {

    switch (remainingGuess) {
      case 0:
        MessagePrinter.printLoseMessage();
        Main.main(null);
        break;
      case 1:
<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
        SnowmanPrinter.printHalfSnowman();
        break;
      case 2:
        SnowmanPrinter.printWithNoLowerBodySnowman();
        break;
      case 3:
        SnowmanPrinter.printNeutralFaceSnowman();
        break;
      default:
        SnowmanPrinter.printHappySnowman();
=======
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
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
        break;
    }
  }

  private static void printHappySnowman() {
<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
    printHat();
=======
    hat();
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
  private static void printNeutralFaceSnowman() {
    printHat();
=======
  private static void printNeutralSnowman() {
    hat();
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
    System.out.println(neutralFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
  private static void printWithNoLowerBodySnowman() {
=======
  private static void printTopBodyOnlySnowman() {
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
    printHalfSnowman();
    System.out.println(bodyTop);
  }

  private static void printHalfSnowman() {
<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
    printHat();
=======
    hat();
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
    System.out.println(sadFace);
  }

  private static void printHat() {
    System.out.println(hatTop);
    System.out.println(hatLow);
  }

<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
  public static void youWinSnowman() {
    System.out.println("Congratulations! You Win.");
    /*
=======
  public static void printWinMessage() {
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
    System.out.println("\n"
        + "░█████╗░░█████╗░███╗░░██╗░██████╗░██████╗░░█████╗░████████╗██╗░░░██╗██╗░░░░░░█████╗░████████╗██╗░█████╗░███╗░░██╗░██████╗\n"
        + "██╔══██╗██╔══██╗████╗░██║██╔════╝░██╔══██╗██╔══██╗╚══██╔══╝██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║██╔════╝\n"
        + "██║░░╚═╝██║░░██║██╔██╗██║██║░░██╗░██████╔╝███████║░░░██║░░░██║░░░██║██║░░░░░███████║░░░██║░░░██║██║░░██║██╔██╗██║╚█████╗░\n"
        + "██║░░██╗██║░░██║██║╚████║██║░░╚██╗██╔══██╗██╔══██║░░░██║░░░██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║██║░░██║██║╚████║░╚═══██╗\n"
        + "╚█████╔╝╚█████╔╝██║░╚███║╚██████╔╝██║░░██║██║░░██║░░░██║░░░╚██████╔╝███████╗██║░░██║░░░██║░░░██║╚█████╔╝██║░╚███║██████╔╝\n"
        + "░╚════╝░░╚════╝░╚═╝░░╚══╝░╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═════╝░");
    System.out.println("\n" + "██╗░░░██╗░█████╗░██╗░░░██╗  ░██╗░░░░░░░██╗██╗███╗░░██╗\n"
        + "╚██╗░██╔╝██╔══██╗██║░░░██║  ░██║░░██╗░░██║██║████╗░██║\n"
        + "░╚████╔╝░██║░░██║██║░░░██║  ░╚██╗████╗██╔╝██║██╔██╗██║\n"
        + "░░╚██╔╝░░██║░░██║██║░░░██║  ░░████╔═████║░██║██║╚████║\n"
        + "░░░██║░░░╚█████╔╝╚██████╔╝  ░░╚██╔╝░╚██╔╝░██║██║░╚███║\n"
        + "░░░╚═╝░░░░╚════╝░░╚═════╝░  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝");

        */
  }

<<<<<<< HEAD:src/main/java/com/snowman/view/SnowmanPrinter.java
  public static void youLoseSnowman() {
    System.out.println("Sorry! You loose.");

   /* System.out.println("\n" + "██╗░░░██╗░█████╗░██╗░░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗\n"
=======
  public static void printLoseMessage() {
    System.out.println("\n" + "██╗░░░██╗░█████╗░██╗░░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗\n"
>>>>>>> master:src/main/java/com/snowman/view/MessagePrinter.java
        + "╚██╗░██╔╝██╔══██╗██║░░░██║  ██║░░░░░██╔══██╗██╔════╝██╔════╝\n"
        + "░╚████╔╝░██║░░██║██║░░░██║  ██║░░░░░██║░░██║╚█████╗░█████╗░░\n"
        + "░░╚██╔╝░░██║░░██║██║░░░██║  ██║░░░░░██║░░██║░╚═══██╗██╔══╝░░\n"
        + "░░░██║░░░╚█████╔╝╚██████╔╝  ███████╗╚█████╔╝██████╔╝███████╗\n"
        + "░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚══════╝░╚════╝░╚═════╝░╚══════╝");

    */
  }

  public static void printCurrentState(int remainingGuess, String wordPlaceholder,
      Set<String> triedWords) {
    System.out.println("Your remaining guesses: " + remainingGuess);
    System.out.println("You have tried so far: " + triedWords);
    System.out.println("Mystery word : " + wordPlaceholder);
  }

}



