package soo.code.hackerrank.test;

import java.util.Scanner;

public class SherlockValidString {

  static String isValid(String s) {
    int sLength = s.length();
    char[] chars = s.toCharArray();
    int standardCount = 0;
    boolean isValid = true;


    //Condition
    //standarCount를 셀때 i, i+1 을 잰다.
    //standardCount 1이상일때 i-1, i를 잰다.


    for (int i = 0; i < sLength - 1; i++) {
      if (chars[i] == chars[i + 1]) {
        standardCount++;
      } else  {

      }
    }

    return isValid ? "YES" : "NO";
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    String result = isValid(s);
    System.out.println(result);
  }
}
