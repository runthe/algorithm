package soo.code;

import java.util.Scanner;

public class Ladder {

  private static int[][] ladder;

  public static void main(String[] args) {
    initialize();

    int xLength = ladder.length;
    int yLength = ladder[0].length;


    for (int i = 0; i <= 25; i++) {
      char ch = (char) (i + 65);
      System.out.print(ch);
    }


    for (int i = 0; i < xLength; i++) {
      System.out.print(i + 1 + " ");
      for (int j = 0; j < yLength; j++) {
        System.out.print(ladder[i][j] + " ");
      }
      System.out.println("");
    }

    //print();
  }

  private static void print() {
    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[0].length; j++) {
        System.out.print(ladder[i][j] + " ");
      }
      System.out.println("");
    }
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    ladder = new int[y][x];

    for (int i = 0; i < y; i++) {
      int flag = sc.nextInt() - 1;

      ladder[i][flag] = 1;
      ladder[i][flag + 1] = 1;
    }
  }
}
