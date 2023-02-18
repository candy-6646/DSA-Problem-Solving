/********************************************************
In each pass we find a minimum element and place it at it's correct position

Unstable sorting Algo.
Not adaptive

************************************************************/


public static void selectionSort(int []arr)
	{
	    int n = arr.length;
	    for(int i=0;i<n-1;i++)
	    {
	        // I have selcted index i
	        int minIndex = i;
	        for(int j=i+1;j<n;j++)
	        {
	            if(arr[j]<arr[minIndex])
	            {
	                minIndex = j;
	            }
	        }
	        int x = arr[minIndex];
	        arr[minIndex]=arr[i];
	        arr[i]=x;
	        System.out.println("After pass number " + i + " Array is : " + Arrays.toString(arr));
	    }
	    return;
	    
	}
