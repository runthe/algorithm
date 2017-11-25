package soo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {


  public static void main(String[] args) {
    String[] strArray = new String[]{"ss", "gg", "Hh", "zz", "55"};
    int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7};

    List<String> list = new ArrayList<>(Arrays.asList(strArray));

    Arrays.sort(intArray);
    Arrays.sort(strArray, Collections.reverseOrder());
    //문자열 대소문자 구분하여서 정렬
    Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);

    for (String str : strArray) {
      System.out.println(str);
    }

    Collections.sort(list);
    Collections.sort(list, Collections.reverseOrder());

    for (String str : list) {
      System.out.println(str);
    }
  }
}
