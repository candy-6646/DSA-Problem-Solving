/* Maximum of minimum for every window size

    Brute force way is to generate all windows and find min. in all windows, and return max among them
*/

/*****************************Optimised Approach****************************** */
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] nsl = getNextSmallerOnLeft(a, n);
        int[] nsr = getNextSmallerOnRight(a, n);
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            //it will tell in how many windows a[i] can come
            //in which he is minimum, later if we find someOne max then we will update it
            int count = nsr[i]-nsl[i]-1;
            
            //ans following 0-based indexing
            ans[count-1] = Math.max(a[i], ans[count-1]);
        }
        //some entries in ans is still empty
        for(int i = n-2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
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
    static int[] getNextSmallerOnLeft(int[] a, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!st.empty() && a[st.peek()] >= a[i]) st.pop();
            
            if(st.empty()) ans[i] = -1;
            else ans[i] = st.peek();
            
            st.push(i);
        }
        return ans;
    }
}




/***************************BRUTE FORCE SOLUTION********************************/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        int[] nextSamller = getNextSmallerOnRight(a, n);
        int[] ans = new int[n];
        
        //Generating all windows and finding min in all window
        //then max among them storing in ans
        for(int i = 0; i < n; i++) {
            ans[i] = maxInWindow(a, n, i+1, nextSamller); //(i+1) == k(size of window)
        }
        return ans;
    }
    
    static int maxInWindow(int[] a, int n, int k, int[] nextSamller) {
        
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



