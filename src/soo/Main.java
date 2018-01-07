package soo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    String[] test = new String[]{"D", "Z", "A", "C"};
    Set<String> treeSet = new TreeSet<>();
    Collections.addAll(treeSet, test);


    List<? extends String> list = new ArrayList<>();
    list.add(null);

  }
}

class Stack<T> {

  private T[] elemenets;

  public Stack() {
    elemenets = (T[]) new Object[5];
  }
}


