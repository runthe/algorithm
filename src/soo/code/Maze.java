package soo.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {

  private static int[][] arr;
  private static int n, m, min;

  public enum Street {
    OPEN(0),
    CLOSE(1),
    VISIT(2);

    private int code;

    Street(int code) {
      this.code = code;
    }

    public int getCode() {
      return this.code;
    }

    public static boolean isOpen(int code) {
      return code == OPEN.getCode();
    }
  }

  public static void main(String[] args) {
    initialize();
    findPath(n - 1, 0, 1);
    //printArr();
    System.out.println(min);

    return;
  }

  private static void findPath(int x, int y, int cnt) {
    if (x == 0 && y == m - 1) {
      if (min > cnt) {
        min = cnt;
      }

      return;
    }

    move(x, y);

    for (int[] pathPoint : findAroundPathPoints(x, y)) {
      findPath(pathPoint[0], pathPoint[1], cnt + 1);
    }

    arr[x][y] = Street.OPEN.getCode();

    return;
  }

  private static void move(int x, int y) {
    if (Street.isOpen(arr[x][y])) {
      arr[x][y] = Street.VISIT.getCode();
    }
  }

  private static List<int[]> findAroundPathPoints(int x, int y) {
    List<int[]> pathPoints = new ArrayList<>();

    addPathPoints(x, y + 1, pathPoints);
    addPathPoints(x, y - 1, pathPoints);
    addPathPoints(x + 1, y, pathPoints);
    addPathPoints(x - 1, y, pathPoints);

    return pathPoints;
  }

  private static void addPathPoints(int x, int y, List<int[]> pathPoints) {
    if (canAddPathPoints(x, y)) {
      pathPoints.add(new int[]{x, y});
    }
  }

  private static boolean canAddPathPoints(int x, int y) {
    return isValidPointRange(x, y) && Street.isOpen(arr[x][y]);
  }

  private static boolean isValidPointRange(int x, int y) {
    return x <= n - 1 && y <= m - 1 && x >= 0 && y >= 0;
  }

  private static void initialize() {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    min = n * m;

    arr = new int[n][m];

    nLabel:
    for (int i = 0; i < n; i++) {
      String line = sc.next();

      mLabel:
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt("" + line.charAt(j));
      }
    }
  }
}
