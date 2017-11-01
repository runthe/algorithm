package soo.coder;


import java.util.HashMap;
import java.util.Map;

public class TopCoder01 {

  public void countStrings(String[] s) throws Exception {
    Map<String, Integer> hm = new HashMap<>();

    for (int i = 0; i < s.length; i++) {
      if (!hm.containsKey(s[i])) hm.put(s[i], 0);
      hm.put(s[i], hm.get(s[i]) + 1);
    }
  }
}


