package com.snowman;

public class DrawSnowman {

  private static final String hatTop = " *       /*\\  *    *";
  private static final String hatLow = "   *   _/ _ \\_ *   * ";
  private static final String neutralFace = " *   *  (‘< ‘ ) *      *";
  private static final String sadFace = " *   *  (T< T ) *      *";
  private static final String happyFace = " *   *  (^< ^ ) *      *";
  private static final String bodyTop = "   * \\–(  :   )–/   *";
  private static final String noHandsBodyTop = "   *    (  :   )     *";
  private static final String bodyLow = " *    (__: __)  *    *";

  public static void main(String[] args) {

  }
    public static void printHappySnowman() {
    printHat();
    System.out.println(happyFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  public static void printNeutralSnowman () {
   printHat();
    System.out.println(neutralFace);
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.
    System.out.println(bodyLow);
  }

  public static void printSadSnowman () {
    printNoLowBodySnowman();
    System.out.println(bodyLow);
  }


  public static void printNoHandsSnowman () {
    printNoBodySnowman();
    System.out.println(noHandsBodyTop); // TODO: Fix redundancy in printing the snowman.
  }

  public static void printNoLowBodySnowman () {
   printNoBodySnowman();
    System.out.println(bodyTop); // TODO: Fix redundancy in printing the snowman.

  }

 public static void printNoBodySnowman () {
    printHat();
    System.out.println(sadFace);
  }


  public static void printHat() {
    System.out.println(hatTop);
    System.out.println(hatLow);
  }

}



