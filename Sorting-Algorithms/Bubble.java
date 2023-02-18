/***************************************************************
In each pass the heaviest element settles at back
Realtive ordering of same elements is not disturbed (Stable Sorting Algo.)
It can be adaptive, if no swaps found in any pass then break


*****************************************************************/


public static void bubbleSort(int []arr){
	    int n = arr.length;
	    for(int i=0;i<n-1;i++)
	    {
	        // ith pass
	        boolean flag = true;
	        for(int j=0;j<n-1-i;j++)
	        {
	            if(arr[j]>arr[j+1])
	            {
	                flag=false;
	                int temp = arr[j];
	                arr[j]=arr[j+1];
	                arr[j+1]=temp;
	            }
	        }
	        if(flag==true){
	            break;
	        }
	        // i th pass of bubble sort has been performed
	        System.out.println("After pass number " + (i) + Arrays.toString(arr));
	    }
	    return;
	}
