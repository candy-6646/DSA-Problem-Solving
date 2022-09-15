/* circular linked list
In circular linked list the tail of linked list is connected with head of the LL
Don't confuse with loop in LL, loop can be b/w any two nodes but circular always 
connects tail with head */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
  int val;
  Node next;

  public Node(){}
  public Node(int val) {
    this.val = val;
  }
}

class circularLL {
  Node last;

  void insertAtEnd(int val) {
    Node newNode = new Node(val);

    if(last == null) {
      last = newNode;
      last.next = newNode;
      return;
    }

    newNode.next = last.next;
    last.next = newNode;
    last = newNode;
  }
}

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      circularLL l1 = new circularLL();
      for(int i = 0; i < n; i++) {
        l1.insertAtEnd(sc.nextInt());
      }

      int k = sc.nextInt();
      l1.insertAtEnd(k);

      Node head = l1.last.next;
      do {
        System.out.print(head.val + " ");
        head = head.next;
      }while(head != l1.last.next);
	}
}