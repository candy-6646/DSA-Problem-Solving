/*Maximum In Sliding Windows Of Size K


What is ask- find Max. in each window of size k, in an array.
nums = [1,3,-1,-3,5,3,6,7], k = 3
o/p-> [3,3,5,5,6,7]

Approach-
find NextGreaterEle index on right for each arr ele, (if curr ele itself greater than nge[i] = n)
[]nge = [1, 4, 4, 4, 6, 6, 7, 8]

suppose we are in window 5 3 6, we see nge for 5 nge at index 6, which is within window, so now go to 6th
idx, the 6th idx val is 6 and it's nge idx is = 7, 7 is out of window, means 6 is greater in curr, window
*/



import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		//get next greater element on right for each nums[i]
        int[] nextGreater = getNextGreater(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        int j = 0;
        
        for(int i = 0; i <= nums.size()-k; i++) {
           if(j < i) j = i; 
           
           //arr[j]'s next greater ele is out of window
           //means he is the maximum
           while(nextGreater[j] < (i+k)) {
               j = nextGreater[j];
           }
           ans.add(nums.get(j));
        }
        return ans;
	}
    static int[] getNextGreater(ArrayList<Integer> a) {
        int n = a.size();
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i >= 0; i--) {
            while(!st.empty() && a.get(st.peek()) <= a.get(i)) st.pop();
            
            if(st.empty()) ans[i] = n;
            else ans[i] = st.peek();
            
            st.push(i);
        }
        return ans;
    }
}