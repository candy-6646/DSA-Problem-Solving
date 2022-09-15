/* Doubly linked list
In doubly LL a node has three things:- prev, val, next
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
  int val;
  Node next;
  Node prev;

  public Node(){}
  public Node(int val) {
    this.val = val;
  }
}

class doublyLL {
  Node head;
  Node tail;

  void insertAtEnd(int val) {
    Node newNode = new Node(val);

    if(head == null) {
      head = newNode;
      tail = newNode;
      return;
    }

    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
  }

  void insertAtBeg(int val) {
     Node newNode = new Node(val);
     if(head == null) {
      head = newNode;
      tail = newNode;
      return;
    }

    head.prev = newNode;
    newNode.next = head;
    head = newNode;
  }

  void print() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }
}

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      doublyLL l1 = new doublyLL();
      for(int i = 0; i < n; i++) {
        l1.insertAtEnd(sc.nextInt());
      }

      l1.insertAtBeg(k);
      l1.print();

	}
}