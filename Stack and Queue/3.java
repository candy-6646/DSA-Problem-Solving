/* Implement Stack using Queues */

class MyStack {
    Queue<Integer> q1;

    public MyStack() {
       q1 = new LinkedList<>(); 
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        int op = q1.size()-1;
        while(op > 0) {
            q1.add(q1.poll());
            op--;
        }
        int x = q1.poll();
        return x;
    }
    
    public int top() {
        int op = q1.size()-1;
        while(op > 0) {
            q1.add(q1.poll());
            op--;
        }
        int x = q1.poll();
        q1.add(x);
        return x;
    }
    
    public boolean empty() {
        if(q1.size() == 0) return true;
        return false;
    }
}