package com.snowman.view;

import com.snowman.Main;
import java.io.IOException;
import java.util.Random;

public class SnowmanPrinter {

  private static final String hatTop =         "  *      /*\\  *    *";

  private static final String hatLow =         "    *  _/ _ \\_ *   * ";

  private static final String neutralFace =    " *   * ('< ' ) *      *";

  private static final String sadFace =        " *   * (T< T ) *      *";

  private static final String happyFace =      " *   * (^< ^ ) *      *";

  private static final String bodyTop =        "   * \\–(  :   )–/   *";

  private static final String bodyLow =        "   *   (__: __)  *    *";

  public static void printSnowman(int remainingGuess, int wordLength) throws IOException {
    Random rand = new Random(); // TODO: Hide these two lines in SnowmanPrinter
    int sadPoint =
        1 + rand.nextInt(wordLength / 2); // TODO: Make sad point more flexible, not a fixed number.
    switch (remainingGuess) {
      case 0:
        SnowmanPrinter.youLoseSnowman();
        Main.main(null);
        break;
      case 1:
        SnowmanPrinter.noBodySnowman();
        break;
      case 2:
        SnowmanPrinter.noLowBodySnowman();
        break;
      case 3:
        SnowmanPrinter.neutralSnowman();
        break;
      default:
        SnowmanPrinter.happySnowman();
        break;
    }

  }

  private static void happySnowman() {
    hat();
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void neutralSnowman() {
    hat();
    System.out.println(neutralFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  private static void noLowBodySnowman() {
    noBodySnowman();
    System.out.println(bodyTop);
  }

  private static void noBodySnowman() {
    hat();
    System.out.println(sadFace);
  }

  private static void hat() {
    System.out.println(hatTop);
    System.out.println(hatLow);
  }

  public static void youWinSnowman() {
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
  }

  public static void youLoseSnowman() {
    System.out.println("\n" + "██╗░░░██╗░█████╗░██╗░░░██╗  ██╗░░░░░░█████╗░░██████╗███████╗\n"
        + "╚██╗░██╔╝██╔══██╗██║░░░██║  ██║░░░░░██╔══██╗██╔════╝██╔════╝\n"
        + "░╚████╔╝░██║░░██║██║░░░██║  ██║░░░░░██║░░██║╚█████╗░█████╗░░\n"
        + "░░╚██╔╝░░██║░░██║██║░░░██║  ██║░░░░░██║░░██║░╚═══██╗██╔══╝░░\n"
        + "░░░██║░░░╚█████╔╝╚██████╔╝  ███████╗╚█████╔╝██████╔╝███████╗\n"
        + "░░░╚═╝░░░░╚════╝░░╚═════╝░  ╚══════╝░╚════╝░╚═════╝░╚══════╝");
  }

}



