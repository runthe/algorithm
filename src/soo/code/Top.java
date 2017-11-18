package soo.code;

import java.util.Scanner;

/***
 * http://119.201.123.184/30stair/tw/tw.php?pname=tw
 */

public class Top {

  private static int[] tops;
  private static int[] topResults;

  public static void main(String[] args) {
    initialize();
    estimate();
    print();
  }

  private static void print() {
    for (int i = 0; i < topResults.length; i++) {
      System.out.print(topResults[i] + " ");
    }
  }

  private static void estimate() {
    for (int i = 0; i < tops.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (tops[j] >= tops[i]) {
          topResults[i] = j + 1;
          break;
        }
      }
    }
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    int topCount = sc.nextInt();
    tops = new int[topCount];
    topResults = new int[topCount];

    for (int i = 0; i < topCount; i++) {
      tops[i] = sc.nextInt();
    }
  }
}
