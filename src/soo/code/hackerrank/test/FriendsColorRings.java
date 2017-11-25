package soo.code.hackerrank.test;

import java.util.ArrayList;
import java.util.List;

class FriendsColorRings {
  private int m;
  private int n;
  private int[][] copyPicture;

  public static void main(String[] args) {
    FriendsColorRings friendsColorRings = new FriendsColorRings();

    int[][] test = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    int[] result = friendsColorRings.solution(6, 4, test);

    System.out.println(result[0]);
    System.out.println(result[1]);
  }

  private int[] solution(int m, int n, int[][] picture) {
    this.m = m;
    this.n = n;
    this.copyPicture = picture;

    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    for (int i = 0; i < m; i++) {
      int sizeOfOneArea;

      for (int j = 0; j < n; j++) {
        sizeOfOneArea = findAreaAndCalculateMaxSize(i, j, 0, 0);

        if (sizeOfOneArea > 0) {
          numberOfArea++;
          maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
        }
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;

    return answer;
  }

  private boolean isValidPath(int x, int y) {
    if (x >= 0 && y >= 0 && x < m && y < n) {
      return true;
    }

    return false;
  }

  private boolean isPaintedArea(int value) {
    return value > 0;
  }

  private boolean isEqualsColor(int value, int color) {
    return value == color;
  }

  private boolean canAddAroundPaths(int x, int y, int color) {
    return isValidPath(x, y) && isPaintedArea(copyPicture[x][y]) && isEqualsColor(copyPicture[x][y], color);
  }

  private void paintVisiting(int x, int y, int value) {
    copyPicture[x][y] = value;
  }

  private int findAreaAndCalculateMaxSize(int x, int y, int count, int color) {
    int value = copyPicture[x][y];

    if (value == 0) {
      return 0;
    }

    if (value == -1) {
      return count;
    }

    if (count == 0 && isPaintedArea(value)) {
      count++;
      paintVisiting(x, y, -1);
    } else if (count != 0 && isPaintedArea(value) && isEqualsColor(value, color)) {
      count++;
      paintVisiting(x, y, -1);
    } else {
      return count;
    }

    for (int[] aroundPath : findAroundPaths(x, y, value)) {
      count = findAreaAndCalculateMaxSize(aroundPath[0], aroundPath[1], count, value);
    }

    return count;
  }

  private List<int[]> findAroundPaths(int x, int y, int color) {
    List<int[]> aroundPaths = new ArrayList<>();

    addAroundPath(x + 1, y, color, aroundPaths);
    addAroundPath(x - 1, y, color, aroundPaths);
    addAroundPath(x, y + 1, color, aroundPaths);
    addAroundPath(x, y - 1, color, aroundPaths);

    return aroundPaths;
  }

  private void addAroundPath(int x, int y, int color, List<int[]> paths) {
    if (canAddAroundPaths(x, y, color)) {
      paths.add(new int[]{x, y});
    }
  }
}