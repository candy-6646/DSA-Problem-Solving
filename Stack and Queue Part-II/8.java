/* Stock Span Problem 

Brute force way is to keep a count var and ++ it until (nums[i] <= curr day price) and the return count

Optimised way to use a stack to keep track of next Greater ele on left, because no. of days 
b/w that day to curr day is our span

*/


class StockSpanner {
    Stack<Pair> st;
    int count = 0;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        count++;
        while(!st.empty() && st.peek().val <= price) st.pop();
        
        int span = count;
        if(!st.empty()) span = count - st.peek().idx;
        st.push(new Pair(price, count));
        
        return span;
    }
}

class Pair {
    int val;
    int idx;
    
    Pair(int v, int i) {
        val = v;
        idx = i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */