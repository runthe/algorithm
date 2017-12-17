package soo.code.hackerrank.test;

import java.util.HashMap;
import java.util.Map;

//형 안전 다형성 컨테이너 패턴 구현
public class Favorites {

  private Map<Class<?>, Object> favorites = new HashMap<>();

  public <T> void putFavorite(Class<T> type, T instance) {
    if (type == null)
      throw new NullPointerException();
    favorites.put(type, instance);
  }

  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }
}
