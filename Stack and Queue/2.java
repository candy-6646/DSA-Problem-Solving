/* 	Implement Queue Using Arrays */



import java.util.* ;
import java.io.*; 
public class Queue {
    int[] q;
    int front;
    int rear;
    Queue() {
        q = new int[10000];
        front = -1;
        rear = -1;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        if(front == -1) return true;
        return false;
    }

    void enqueue(int data) {
        rear++;
        q[rear] = data;
        if(front == -1) front++;
    }

    int dequeue() {
        if(front == -1) return -1;
        int val = q[front];
        q[front] = 0;
        front++;
        if(front > rear) {
            front = -1;
            rear = -1;
        }
        return val;
    }

    int front() {
        if(front == -1) return -1;
        int val = q[front];
        return val;
    }

}
