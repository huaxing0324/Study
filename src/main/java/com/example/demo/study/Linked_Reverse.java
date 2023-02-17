package com.example.demo.study;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Linked_Reverse {

     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

        Integer integer = Integer.valueOf("1234", 10);
        ListNode n = new ListNode(1);
         ListNode n1 = new ListNode(2);
         ListNode n2 = new ListNode(3);
         ListNode n3 = new ListNode(4);
         ListNode n4 = new ListNode(5);
        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode pre = null;
        ListNode cur = n;
        while (cur != null){



        }



    }
}
