package soo.effetive;

public class Generic {

  public static void main(String[] args) {
    Object[] objectArray = new Long[1];
    objectArray[0] = "I don't fit in"; //ArrayStoreException 예외 발생

    //List<Object> objectList = new ArrayList<Long>();// 자료형 불일치
    //objectList.add("I don't fit in");

    //List<String>[] stringLists = new List<String>[1];
    //List<Integer> intList = Arrays.asList(42);
    //Object[] objects = stringLists;
  }
}
