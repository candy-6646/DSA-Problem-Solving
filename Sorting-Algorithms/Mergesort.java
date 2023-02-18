/********************************************************
Not Adaptive, for sorted input it takes Nlog(N)
Stable sort


*****************************************************************/


import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int []arr = {8,6,9,5,10,7};
		mergesort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergesort(int[] arr, int l, int r)
	{
	    if(l>=r){
	        return;
	    }
	    int mid = (l+r)/2;
	    mergesort(arr,l,mid);
	    mergesort(arr,mid+1,r);
	    merge(arr,l,mid,r);
	}
	public static void merge(int []arr, int l, int mid, int r)
	{
	    int []temp = new int[arr.length];
	    int i=l;
	    int j=mid+1;
	    int k=l;
	    while(i<=mid && j<=r)
	    {
	        if(arr[i]<=arr[j])
	        {
	            temp[k++]=arr[i++];
	        }
	        else
	        {
	            temp[k++]=arr[j++];
	        }
	    }
	    while(i<=mid){
	        temp[k++]=arr[i++];
	    }
	    while(j<=r){
	        temp[k++]=arr[j++];
	    }
	    for(int p=l;p<=r;p++){
	        arr[p]=temp[p];
	    }
	    
	}
}

