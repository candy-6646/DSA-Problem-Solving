/* Count inversions in an array

By using merge sort - O(n Log-n)
During merging as we know array is paritioned so every ele coming from right i < j & arr[i] > arr[j]
so it is an inversion

*/


import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        long[] temp = new long[n];
        long count = mergeSort(arr, temp, 0, n-1);
        return count;
    }
    
    public static long mergeSort(long arr[], long temp[], int low, int high) {
        int mid;
        long inv_count = 0;
        if(low < high) {
          mid = (low + high) / 2;
          inv_count += mergeSort(arr, temp, low, mid);  
          inv_count += mergeSort(arr, temp, mid+1, high);  
          
          inv_count += merge(arr,temp,low,mid+1,high);
        }
        return inv_count;
    }
    
    public static long merge(long arr[], long temp[], int low, int mid, int high) {
        int inv_count = 0;
        int i = low;
        int j = mid;
        int k = low;
        
        while(i <= mid - 1 && j <= high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }
        while(i <= mid - 1)
            temp[k++] = arr[i++];

        while(j <= high)
            temp[k++] = arr[j++];

        for(i = low ; i <= high ; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}