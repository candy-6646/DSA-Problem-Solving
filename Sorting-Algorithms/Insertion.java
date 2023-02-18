/****************************************************************
In insertionSort alog. we divide our array in two halves, one is sorted and another is unsorted
In each pass we select a element from unsorted half and place it in correct position in sorted half

It is an adaptive algorithm, takes O(n) for sorted input
Stable sort


*****************************************************************/

public static void insertionSort(int []arr){
	    int n = arr.length;
	    for(int i=1;i<n;i++)
	    {
	        for(int j=i-1;j>=0;j--)
	        {
	            if(arr[j]>arr[j+1])
	            {
	                int temp = arr[j];
	                arr[j]=arr[j+1];
	                arr[j+1]=temp;
	            }
	            else
	            {
	                break;
	            }
	        }
	        System.out.println("After pass number " + (i) + Arrays.toString(arr));
	    }
	    return;
	}
