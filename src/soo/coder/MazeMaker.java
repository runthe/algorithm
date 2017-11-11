package soo.coder;


import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {

  /**
   * 미로 밖으로 나가지 못하게 하고 싶다
   * 주인공이 미로에서 항상 최단 경로로 탈출한다고 할 때 짐이 미로에서 벗어 날수 있는 최대 이동 횟수를 리턴하세요
   * 미로를 빠져나올수 없는 경우에는 -1을 리턴해주세요.
   *
   * @param args
   */

  public static void main(String[] args) {
    int path = longestPath(new String[]{"...", "...", "..."}, 0, 1, new int[]{1, 0, -1, 0}, new int[]{0, 1, 0, -1});

    System.out.println(path);
  }

  public static int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
    int max = 0;
    int width = maze[0].length(),
      height = maze.length;

    int[][] board = new int[height][width];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = -1;
      }
    }

    board[startRow][startCol] = 0;
    Queue<Integer> queueX = new LinkedList<>();
    Queue<Integer> queueY = new LinkedList<>();
    queueX.add(startCol);
    queueY.add(startRow);

    while (!queueX.isEmpty()) {
      int x = queueX.poll(),
        y = queueY.poll();

      for (int i = 0; i < moveRow.length; i++) {
        int nextX = x + moveCol[i];
        int nextY = y + moveRow[i];

        if (0 <= nextX && nextX < width && 0 <= nextY && nextY < height && board[nextY][nextX] == -1
          && maze[nextY].charAt(nextX) == '.') {
          board[nextY][nextX] = board[y][x] + 1;
          queueX.add(nextX);
          queueY.add(nextY);
        }
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        if (maze[i].charAt(j) == '.' && board[i][j] == -1) {
          return -1;
        }

        max = Math.max(max, board[i][j]);
      }
    }

    return max;
  }
}
