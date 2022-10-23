/* Implement Queue using Stack (0(1) amortized method) */


import java.util.*;
public class Queue {
    Stack<Integer> mst, hst;

    Queue() {
        mst = new Stack<>();
        hst = new Stack<>();
    }

    void enQueue(int val) {
        mst.push(val);
    }

    int deQueue() {
        if(hst.empty() && mst.empty()) return -1;
        if(!hst.empty()) return hst.pop();
        while(!mst.empty()) hst.push(mst.pop());
        return hst.pop();
    }

    int peek() {
        if(hst.empty() && mst.empty()) return -1;
        if(!hst.empty()) return hst.peek();
        while(!mst.empty()) hst.push(mst.pop());
        return hst.peek();
    }

    boolean isEmpty() {
         if(hst.empty() && mst.empty()) return true;
        return false;
    }
}