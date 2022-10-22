/* 4. Median of Two Sorted Arrays
*/



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merging the arrays
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m+n) / 2;
        int count = -1;
        int midElem = -1;
        int midPrev = -1;
        while(i < m && j < n) {
            count++;
            if(nums1[i] <= nums2[j]) {
                i++;
                if(count == mid-1) midPrev = nums1[i-1];
                if(count == mid) midElem = nums1[i-1];
            }else{
                j++;
                if(count == mid-1) midPrev = nums2[j-1];
                if(count == mid) midElem = nums2[j-1];
            } 
        }
        
        while(i < m) {
            count++;
            i++;
            if(count == mid-1) midPrev = nums1[i-1];
            if(count == mid) midElem = nums1[i-1];
        }
        
        while(j < n) {
            count++;
            j++;
            if(count == mid-1) midPrev = nums2[j-1];
            if(count == mid) midElem = nums2[j-1];
        }
        // System.out.println(midPrev + " " + midElem);
        
        if((m+n) % 2 != 0) {
            return midElem / 1.0;
        }else {
            return (midElem + midPrev) / 2.0;
        }
    }
}