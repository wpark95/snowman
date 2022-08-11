package com.snowman.view;

import com.snowman.Main;
import java.io.IOException;

public class SnowmanPrinter {

  private static final String hatTop =         "  *      /*\\  *    *";

  private static final String hatLow =         "    *  _/ _ \\_ *   * ";

  private static final String neutralFace =    " *   * ('< ' ) *      *";

  private static final String sadFace =        " *   * (T< T ) *      *";

  private static final String happyFace =      " *   * (^< ^ ) *      *";

  private static final String bodyTop =        "   * \\–(  :   )–/   *";

  private static final String bodyLow =        "   *   (__: __)  *    *";

  public static void printSnowman(int remainingGuess) throws IOException {

    switch (remainingGuess) {
      case 0:
        SnowmanPrinter.youLoseSnowman();
        Main.main(null);
        break;
      case 1:
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
        break;
    }

  }

  private static void printHappySnowman() {
    printHat();
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void printNeutralFaceSnowman() {
    printHat();
    System.out.println(neutralFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void printWithNoLowerBodySnowman() {
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

  public static void youWinSnowman() {
    System.out.println("Congratulations! You Win.");
    /*
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

  public static void youLoseSnowman() {
    System.out.println("Sorry! You loose.");

   /* System.out.println("\n" + "██╗░░░██╗░█████╗░██╗░░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗\n"
        + "╚██╗░██╔╝██╔══██╗██║░░░██║  ██║░░░░░██╔══██╗██╔════╝██╔════╝\n"
        + "░╚████╔╝░██║░░██║██║░░░██║  ██║░░░░░██║░░██║╚█████╗░█████╗░░\n"
        + "░░╚██╔╝░░██║░░██║██║░░░██║  ██║░░░░░██║░░██║░╚═══██╗██╔══╝░░\n"
        + "░░░██║░░░╚█████╔╝╚██████╔╝  ███████╗╚█████╔╝██████╔╝███████╗\n"
        + "░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚══════╝░╚════╝░╚═════╝░╚══════╝");

    */
  }

}



