package com.snowman;

public class SnowmanPrinter {

  private static final String hatTop = " *       /*\\  *    *";
  private static final String hatLow = "   *   _/ _ \\_ *   * ";
  private static final String neutralFace = " *   *  (‘< ‘ ) *      *";
  private static final String sadFace = " *   *  (T< T ) *      *";
  private static final String happyFace = " *   *  (^< ^ ) *      *";
  private static final String bodyTop = "   * \\–(  :   )–/   *";
  private static final String noHandsBodyTop = "   *    (  :   )     *";
  private static final String bodyLow = " *    (__: __)  *    *";
  private static final String hatTop1 = "         /*\\        ";
  private static final String hatLow1 = "       _/ _ \\_       ";
  private static final String sadFace1 = "        (T< T )         ";
  private static final String bodyTop1 = "     \\–(  :   )–/    ";
  private static final String bodyLow1 = "      (__: __)        ";


  public static void printSnowman(int sadPoint, int remainingGuess) {
    if (remainingGuess > sadPoint) { // Prints out happy snowman
      SnowmanPrinter.happySnowman();
    } else if (remainingGuess == sadPoint) {
      SnowmanPrinter.neutralSnowman();
    } else if (remainingGuess == sadPoint) {
    } else if (remainingGuess < sadPoint - 2) {
      System.out.println("Good job. You killed the snowman.");
      SnowmanPrinter.sadSnowman();
    } else if (remainingGuess < sadPoint - 1) {
      SnowmanPrinter.noBodySnowman();
    } else {
      SnowmanPrinter.lowSnowSnowman();
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

  public static void sadSnowman() {
    noLowBodySnowman();
    System.out.println(bodyTop);
    System.out.println(bodyLow);
  }

  public static void lowSnowSnowman() {
    System.out.println(hatTop1);
    System.out.println(hatLow1);
    System.out.println(sadFace1);
    System.out.println(bodyTop);
    System.out.println(bodyLow);
  }

  public static void noSnowSnowman() {
    System.out.println(hatTop1);
    System.out.println(hatLow1);
    System.out.println(sadFace1);
    System.out.println(bodyTop1);
    System.out.println(bodyLow1);
  }

  public static void noHandSnowman() {
    noBodySnowman();
    System.out.println(noHandsBodyTop);
  }

  public static void noLowBodySnowman() {
    noBodySnowman();
    System.out.println(bodyTop);
  }

  public static void noBodySnowman() {
    hat();
    System.out.println(sadFace);
  }

  public static void hat() {
    System.out.println(hatTop);
    System.out.println(hatLow);
  }

}



