/* Implement Stack Using Arrays */

import java.util.* ;
import java.io.*; 

public class Stack {
    int[] st;
    int top = -1;
    
    public Stack(int cap) {
        st = new int[cap];
    }
    void push(int num) {
        if(top + 1 == st.length) return;
        top++;
        st[top] = num;
    }
    int pop() {
        if(top == -1) return -1;
        int val = st[top];
        top--;
        return val;
    }
    int top() {
        if(top == -1) return -1;
        int val = st[top];
        return val;
    }
    int isEmpty() {
        if(top == -1) return 1;
        return 0;
    }
    int isFull() {
        if(top + 1 == st.length) return 1;
        return 0;
    }
}
