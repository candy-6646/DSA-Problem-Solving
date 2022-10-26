/* Stack and Queue Part-II */


import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        //next smaller ele on right
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            int curr = arr.get(i);
            while(!st.empty() && st.peek() >= curr) st.pop();
            
            if(st.empty()) arr.set(i, -1);
            else arr.set(i, st.peek());
            
            st.push(curr);
        }
        
        return arr;
    }
}