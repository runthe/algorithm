package soo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
      System.out.print(str + " ");
    }
    System.out.println();

    Collections.sort(list);
    Collections.sort(list, Collections.reverseOrder());

    for (String str : list) {
      System.out.print(str + " ");
    }
    System.out.println();

    //TreeSet, TreeMap 등이 있음
    String[] test = new String[]{"D", "Z", "A", "C"};
    Set<String> treeSet = new TreeSet<>();
    Collections.addAll(treeSet, test);

    System.out.println(treeSet);

    List<PhoneNumber> phoneNumbers = new ArrayList<>();

    phoneNumbers.add(new PhoneNumber("HAAA", 29));
    phoneNumbers.add(new PhoneNumber("HAAA", 19));
    phoneNumbers.add(new PhoneNumber("Kim", 30));
    phoneNumbers.add(new PhoneNumber("Koo", 10));
    phoneNumbers.add(new PhoneNumber("Bob", 5));
    phoneNumbers.add(new PhoneNumber("Bow", 20));
    phoneNumbers.add(new PhoneNumber("Baw", 3));

    Collections.sort(phoneNumbers);
    System.out.println(phoneNumbers);

  }
}
