package soo.effetive;

import java.io.Serializable;
import java.util.Comparator;

public class Host {
  private static class StrLenCmp implements Comparator<String>, Serializable {

    @Override
    public int compare(String o1, String o2) {
      return o1.length() - o2.length();
    }
  }

  public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

  public static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
    @Override
    public int compare(Integer i1, Integer i2) {
      return i1 - i2;
    }
  };

  public static final Comparator<Integer> LAMDA_COMPARATOR = (i1, i2) -> i1 - i2;
}
