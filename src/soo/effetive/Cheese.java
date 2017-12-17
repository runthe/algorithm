package soo.effetive;

import java.util.ArrayList;
import java.util.List;

public class Cheese {
  //컬렉션에서 배열을 만들어 반환하는 올바른 방법
  private final List<Cheese> cheeseList = new ArrayList<>();
  private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

  public Cheese[] getCheeses() {
    return cheeseList.toArray(EMPTY_CHEESE_ARRAY);
  }
}
