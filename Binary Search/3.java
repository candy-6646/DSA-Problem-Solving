/* Search Single Element in a sorted array 


How we are finding where to go ?
        we can think that the array is divided into two parts
        left part is before the unique ele
        Right part is after the unique ele
        Ex - nums=[1,1,2,3,3,4,4,8,8]
        
        intiution is that we can see on left 1->0(odd-idx) and 1->1(even-idx)
        but on right 3->3(odd-idx) and 3->4(even-idx)
        
        if first instance is odd and second is on even then we can say that our answer
        lies on left, hi = mid-1;
        
        if first instance is even and sec on odd then we can say out answer lies on 
        right, lo = mid+1;
        

*/


class Solution {
    public int singleNonDuplicate(int[] arr) {
        int l = 0;
        int r = arr.length;
        
        while(l <= r) {
            int mid = (l+r) / 2;
            
            int left = -1;
            int right = -1;
            
            if(mid != 0 && arr[mid] == arr[mid-1]) left = mid-1;
            if(mid != arr.length -1 && arr[mid] == arr[mid+1]) right = mid+1;
            
            //if left not exist and right also not exist then it's a unique ele
            if(left == -1 && right == -1) return arr[mid];

            //if left exits means first instance on left and sec on mid
            else if(left != -1) {
                //if first instance is on odd-idx means sec on even-idx
                if(left % 2 != 0) r = mid-1;
                else l = mid+1;

            //if right exits means first instance on mid and sec on right
            }else {
                //if sec instance is on even-idx means first is on odd-idx
                if(right % 2 == 0) r = mid-1;
                else l = mid+1;
            }
        }
        
        return -1;
    }
}