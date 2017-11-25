package soo.code;

import java.util.Scanner;

public class Ladder {

  private static int[][] ladder;
  private static int ladderX;
  private static int ladderY;

  public static void main(String[] args) {
    initialize();
    start();
  }

  private static void start() {
    for (int i = 0; i < ladderY; i++) {
      System.out.print(i + 1 + " ");
      ride(0, i);
    }
  }

  private static void ride(int x, int y) {
    if (x == ladderX) {
      System.out.println((char) (y + 65));
      return;
    }

    int moveX = 0, moveY = 0;

    if (isOne(ladder[x][y])) {
      if (isValidPath(x, y - 1) && isOne(ladder[x][y - 1])) {
        moveX = x + 1;
        moveY = y - 1;
      }

      if (isValidPath(x, y + 1) && isOne(ladder[x][y + 1])) {
        moveX = x + 1;
        moveY = y + 1;
      }
    } else {
      moveX = x + 1;
      moveY = y;
    }

    ride(moveX, moveY);
  }

  private static boolean isOne(int value) {
    return value == 1;
  }

  private static boolean isValidPath(int x, int y) {
    return x >= 0 && y >= 0 && x < ladderX && y < ladderY;
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    ladderY = sc.nextInt();
    ladderX = sc.nextInt();

    ladder = new int[ladderX][ladderY];

    for (int i = 0; i < ladderX; i++) {
      int flag = sc.nextInt() - 1;

      ladder[i][flag] = 1;
      ladder[i][flag + 1] = 1;
    }
  }
}
