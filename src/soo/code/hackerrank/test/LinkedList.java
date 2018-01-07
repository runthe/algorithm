package soo.code.hackerrank.test;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

  public static class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode(int node_value) {
      val = node_value;
      next = null;
    }
  }

  public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
    if (head == null) {
      head = new LinkedListNode(val);
      tail = head;
    } else {
      tail.next = new LinkedListNode(val);
      tail = tail.next;
    }
    return tail;
  }


  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(3);
    LinkedListNode next1 = head.next = new LinkedListNode(4);
    LinkedListNode next2 = next1.next = new LinkedListNode(5);
    LinkedListNode tail = next2.next = new LinkedListNode(6);

    LinkedListNode result = deleteOdd(head);

    System.out.println(result.val);
    System.out.println(result.next.val);
  }


  private static LinkedListNode deleteOdd(LinkedListNode list) {
    final List<Integer> evens = new ArrayList<>();
    extractEvensByNodeList(list, evens);

    LinkedListNode _list = null;
    LinkedListNode _list_tail = null;

    for (int i = 0; i < evens.size(); i++) {
      int even = evens.get(i);

      if (i == 0) {
        _list = _insert_node_into_singlylinkedlist(_list, _list_tail, even);
        _list_tail = _list;
      } else {
        _list_tail = _insert_node_into_singlylinkedlist(_list, _list_tail, even);
      }
    }

    return _list;
  }

  private static List<Integer> extractEvensByNodeList(LinkedListNode list, List<Integer> evenLists) {
    if (isEven(list.val)) {
      evenLists.add(list.val);
    }

    if (list.next != null) {
      extractEvensByNodeList(list.next, evenLists);
    }

    return evenLists;
  }

  private static boolean isEven(int val) {
    return val % 2 == 0;
  }
}
