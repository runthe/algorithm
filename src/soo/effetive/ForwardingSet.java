package soo.effetive;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet<E> implements Set<E> {

  private final Set<E> s;

  public ForwardingSet(Set<E> s) {
    this.s = s;
  }

  @Override
  public int size() {
    return s.size();
  }

  @Override
  public boolean isEmpty() {
    return s.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return s.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return s.iterator();
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return null;
  }

  @Override
  public boolean add(E e) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }
}
