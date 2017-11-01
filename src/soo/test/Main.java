package soo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  /**
   * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
   * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
   * <p>
   * 제한사항
   * N의 범위 : 100,000,000 이하의 자연수
   * 입출력 예
   * N	answer
   * 123	6
   * 987	24
   * 입출력 예 설명
   * 입출력 예 #1
   * 문제의 예시와 같습니다.
   * <p>
   * 입출력 예 #2
   * 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
   *
   * @param args
   */


  public static void main(String[] args) {
    System.out.println("Hello World!");
    //System.out.println(new soo.test.Solution().solution(123));
    //System.out.println(new soo.test.Solution2().solution(new int[]{4, 3, 1, 2}));
    //System.out.println(result[0] + "," + result[1]);
    //[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]

    int[][] table = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
    System.out.println(table.length);
    int result = new Solution4().solution(table);
    System.out.println(result);
  }
}

class Solution {
  public int solution(int n) {
    if (100000000 >= n) {
      int answer = 0;

      while (n != 0) {
        answer += n % 10;

        n = n / 10;
      }

      return answer;
    }

    return 0;
  }
}

class Solution2 {
  /**
   * 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
   * 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.
   * <p>
   * 제한사항
   * 배열의 길이는 10만 이하입니다.
   * 배열의 원소는 10만 이하의 자연수입니다.
   * 퀵소트 알고리즘을 이용해야한다.
   */

  public boolean solution(int[] arr) {
    int arrLength = arr.length;
    Arrays.sort(arr);

    if (arrLength <= 100000) {
      A:
      for (int i = 0; i < arrLength; i++) {
        if (arr[i] != i + 1) {
          return false;
        }

      }
    }

    return true;
  }
}


class Solution3 {
  /**
   * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
   * <p>
   * 제한사항
   * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
   * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
   * 좌표값은 1 이상 10억 이하의 자연수입니다.
   * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
   * 입출력 예
   * v	result
   * [[1, 4], [3, 4], [3, 10]]	[1, 10]
   * [[1, 1], [2, 2], [1, 2]]	[2, 1]
   * 입출력 예 설명
   * 입출력 예 #1
   * 세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.
   * <p>
   * 입출력 예 #2
   * 세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.
   */

  public int[] solution(int[][] v) {
    int vLength = v.length;

    int[] xArray = new int[3];
    int[] yArray = new int[3];

    for (int i = 0; i < vLength; i++) {
      int[] rectArray = v[i];

      xArray[i] = rectArray[0];
      yArray[i] = rectArray[1];
    }

    Arrays.sort(xArray);
    Arrays.sort(yArray);

    int[] result = new int[2];
    result[0] = (xArray[0] == xArray[1]) ? xArray[2] : xArray[0];
    result[1] = (yArray[0] == yArray[1]) ? yArray[2] : yArray[0];

    return result;
  }
}

class Solution4 {

  public int solution(int[][] v) {
    int xLength = v.length;
    int yLength = v[0].length;
    int maxWidth = 0;
    List<int[]> cacheList = new ArrayList();

    A:
    for (int i = 0; i < xLength; i++) {
      int widthCount = 0;

      B:
      for (int j = 0; j < yLength; j++) {
        int value = v[i][j];
        System.out.print(value + " ");

        if (isValidValue(value)) {
          widthCount++;
        }

        if (j == yLength - 1 || !isValidValue(value)) {
          int widthCountIndex = widthCount - 1;

          //너비가 2이상, x행이 정사각형 너비가 되는지 && 각각 포인트가 1인지 체크
          if (widthCount >= 2 && i + (widthCountIndex) < xLength && isValidSquarePoint(v, i, j, widthCount)) {
            C:
            for (int k = i + 1; k <= widthCountIndex; k++) {
              int lWidthCount = 0;

              D:
              for (int l = j - widthCountIndex; l <= widthCountIndex; l++) {
                if (isValidValue(v[k][l])) {
                  lWidthCount++;
                } else {
                  widthCount = 0;
                  break C;
                }
              }
            }

            if (widthCount != 0) {
              maxWidth = widthCount > maxWidth ? widthCount : maxWidth;

              if (maxWidth == xLength) {
                break A;
              }
            }

          }
        }

        if (!isValidValue(value)) {
          widthCount = 0;
        }
      }

      System.out.println("");
    }

    return maxWidth * maxWidth;
  }

  private boolean isValidSquarePoint(int[][] v, int i, int j, int widthCount) {
    int widthCountIndex = widthCount - 1;

    return isValidValue(v[i + widthCountIndex][j - widthCountIndex]) && isValidValue(v[i + widthCountIndex][j]);
  }

  private boolean isValidValue(int value) {
    return value == 1;
  }
}

class BinToHex {

  public boolean compareBinToHex(String binary, String hex) {
    int n1 = convertToBase(binary, 2);
    int n2 = convertToBase(hex, 16);

    if (n1 < 0 || n2 < 0) {
      return false;
    } else {
      return n1 == n2;
    }
  }

  public int digitToValue(char c) {
    if (c >= '0' && c <= '9') return c - '0';
    else if (c >= 'A' && c <= 'F') return 10 + c - 'A';
    else if (c >= 'a' && c <= 'f') return 10 + c - 'a';
    return -1;
  }

  public int convertToBase(String number, int base) {
    if (base < 2 || (base > 10 && base != 16)) return -1;
    int value = 0;

    for (int i = number.length() - 1; i >= 0; i--) {
      int digit = digitToValue(number.charAt(i));

      if (digit < 0 || digit >= base) {
        return -1;
      }

      int exp = number.length() - 1 - i;
      value += digit * Math.pow(base, exp);
    }

    return value;
  }
}

class SwapMinMax {
  public static int getMinIndex(int[] array) {
    int minIndex = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] < array[minIndex]) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  public static int getMaxIndex(int[] array) {
    int maxIndex = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] > array[maxIndex]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  public static void swap(int[] array, int m, int n) {
    int temp = array[m];
    array[m] = array[n];
    array[n] = temp;
  }

  public static void swapMinMaxBetter(int[] array) {
    //TODO:: 람다 표현식 활용 방법 알아내기
    int minIndex = getMinIndex(array);
    int maxIndex = getMaxIndex(array);

    swap(array, minIndex, maxIndex);
  }
}

class StringBufferExample {
  public String joinWords(String[] words) {
    String sentence = "";

    for (String w : words) {
      sentence = sentence + w;
    }

    return sentence;
  }
}
