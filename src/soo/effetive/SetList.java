package soo.effetive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetList {

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    for (int i = -3; i < 3; i++) {
      set.add(i);
      list.add(i);
    }

    System.out.println(set + " " + list);

    for (int i = 0; i < 3; i++) {
      set.remove(i);
      list.remove(i);
      //list.remove((Integer)i);
    }

    System.out.println(set + " " + list);
  }


}
