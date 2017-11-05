package soo.coder;

public class CrazyBot {


  /**
   * 고장난 로봇
   * 고장난 로봇이 평면 위에 있습니다. 그리고 n번 움직입니, 로봇은 각 단계에서 한 방향을 선택해서 한 칸 움직입니다 로봇이 동, 서 ,남 북을 선택할 확률은 %입니다
   * double 형 자료로 리턴하며 같은 지점을 통과하지 않으면 성공했다고 봅니다.
   */

  private static boolean[][] grid = new boolean[100][100];
  private static double[] percentages = new double[4];
  private static int[] vx = {1, -1, 0, 0};
  private static int[] vy = {0, 0, 1, -1};

  public static void main(String[] args) {
    System.out.println(getProbability(2, 25, 25, 25, 25));
    //System.out.println(getProbability(7, 50, 25, 25, 50));
  }

  public static double getProbability(int n, int east, int west, int south, int north) {
    percentages[0] = east / 100.0;
    percentages[1] = west / 100.0;
    percentages[2] = south / 100.0;
    percentages[3] = north / 100.0;

    //가운데서 시작하니까 50, 50
    return dfs(50, 50, n);
  }

  private static double dfs(int x, int y, int n) {
    if (grid[x][y]) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    grid[x][y] = true;
    double ret = 0;

    for (int i = 0; i < 4; i++) {
      ret += dfs(x + vx[i], y + vy[i], n - 1) * percentages[i];
    }

    grid[x][y] = false;
    return ret;
  }
}
