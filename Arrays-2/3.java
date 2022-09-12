/* Merge two Sorted Arrays Without Extra Space 

Merge sort is efficient but took extra space

Iterate over arr1 and whenever we get arr1[i] > arr2[0] swap them, then re-arrange arr2

Gap Sort - while(gap > 0), i = 0 and j = gap, iterate over arr1 and arr2 with these pointers
whenever val at i > val at j, swap them;

*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        for(int i = m; i < (n+m); i++, k++) {
            nums1[i] = nums2[k];
        }
        
        int gap = (int) Math.ceil((double)(n+m) / 2.0);
        
        while(gap > 0) {
            int i = 0;
            int j = gap;
            
            while(j < (m + n)) {
                if(nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                
                i++;
                j++;
            }
            
            if(gap == 1) {
                gap = 0;
            }else {
                gap = (int) Math.ceil((double)(gap) / 2.0);
            }
        }
    }
}