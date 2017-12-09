package soo.effetive;

import java.util.AbstractSet;
import java.util.Iterator;

public class MySet<E> extends AbstractSet<E> {
  @Override
  public Iterator<E> iterator() {
    return new MyIterator<>();
  }

  @Override
  public int size() {
    return 0;
  }

  private class MyIterator<E> implements Iterator<E>{

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      return null;
    }
  }
}
