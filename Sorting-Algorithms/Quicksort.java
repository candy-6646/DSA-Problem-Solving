/****************************************************************************

TC of Quicksort is highly dependent on where the partition is happening
for sorted input if we take arr[l] as pivot then TC-O(N^2)
Not stable

*******************************************************************************/


    static void quickSort(int[] arr, int l, int r){
        if(l >= r) return;

		int pi = partition(arr, l, r);
		quickSort(arr, l, pi-1);
		quickSort(arr, pi+1, r);
    }

	static int partition(int[] arr, int l, int r) {
		int pivot = arr[l];
		int i = l;
		int j = r;

		while(i < j) {
			while(i <= r && arr[i] <= pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}

			if(i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}

		arr[l] = arr[j];
		arr[j] = pivot;

		return j;
	}