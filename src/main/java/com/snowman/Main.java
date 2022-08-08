package com.snowman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

  public static void main(String[] args) throws IOException {
    Reader input =  new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    System.out.println(reader.readLine());
  }

}
