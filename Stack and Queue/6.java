/* Next Greater Element II 


find next greater ele on right for a nums[i] if not found then find in previous values of arr(circular)
*/


/******************************Optimised 2(N) solution********************************** */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        for(int i  = n-1; i >= 0; i--) {
            st.push(nums[i]);
        }
        
        for(int i = n-1; i >= 0; i--) {
            if(st.empty()) {
                ans[i] = -1;
            }else {
                while(!st.empty() && st.peek() <= nums[i]) st.pop();
                
                if(st.empty()) ans[i] = -1;
                else ans[i] = st.peek();
            }
            
            st.push(nums[i]);
        }
        
        return ans;
    }
}