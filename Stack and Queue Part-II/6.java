/* Implement Min Stack

Need to perform All operations in constant time.

One way is to use a single LL
    place recent nodes at front and point head to front
    Node-> value, next, minimum

Using Two stacks
    st and mst
    push -> push ele in st and check that if mst isEmpty() || mst.peek() >= st.peek(); push ele in mst also
    pop -> if(mst.peek() == st.peek()) pop in both ele pop in st
    getMin -> mst.peek();
    top -> st.peek();
*/


class MinStack {
    Stack<Integer> st;
    Stack<Integer> mst;
    public MinStack() {
        st = new Stack<>();
        mst = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(mst.empty()) mst.push(val);
        else {
            if(mst.peek() >= val) mst.push(val);
        }
    }
    
    public void pop() {
        int p1= st.peek();
        int p2  = mst.peek();
        if(p1 == p2) {
            st.pop();
            mst.pop();
        }else {
            st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */