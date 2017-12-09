package soo.effetive;

import java.util.Map;

public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

  //기본 primitive 메서드
  public abstract K getKey();

  public abstract V getValue();

  public V setValue(V value) {
    throw new UnsupportedOperationException();
  }

}
