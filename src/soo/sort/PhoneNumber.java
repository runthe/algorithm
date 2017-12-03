package soo.sort;

public class PhoneNumber implements Comparable<PhoneNumber> {

  private String name;

  private int age;

  public PhoneNumber(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "PhoneNumber{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }

  @Override
  public int compareTo(PhoneNumber o) {
    int nameDiff = name.compareTo(o.name);

    if (nameDiff != 0) {
      return nameDiff;
    }

    return age - o.age;
  }
}
