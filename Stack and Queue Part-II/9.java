/* Maximum of minimum for every window size

    Brute force way is to generate all windows and find min. in all windows, and return max among them
*/





/***************************BRUTE FORCE SOLUTION********************************/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] ans = new int[n];
        
        //Generating all windows and finding min in all window
        //then max among them storing in ans
        for(int i = 0; i < n; i++) {
            ans[i] = maxInWindow(a, n, i+1); //(i+1) == k(size of window)
        }
        return ans;
    }
    
    static int maxInWindow(int[] a, int n, int k) {
        int[] nextSamller = getNextSmallerOnRight(a, n);
        int j = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= (n-k); i++) {
            if(j < i) j = i;
            
            while(nextSamller[j] < (i+k)) {
                j = nextSamller[j];
            }
            
            max = Math.max(a[j], max);
        }
        
        return max;
    }
    
    static int[] getNextSmallerOnRight(int[] a, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = n-1; i >= 0; i--) {
            while(!st.empty() && a[st.peek()] >= a[i]) st.pop();
            
            if(st.empty()) ans[i] = n;
            else ans[i] = st.peek();
            
            st.push(i);
        }
        return ans;
    }
}

