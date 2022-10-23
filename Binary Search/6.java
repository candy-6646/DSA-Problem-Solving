/* K-th element of two sorted Arrays */


    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int count = 0;
        
        int i = 0, j = 0;
        while(i < n && j < m) {
            count++;
            if(arr1[i] <= arr2[j]) {
                if(count == k) return arr1[i];
                i++;
            }else {
                if(count == k) return arr2[j];
                j++;
            }
            
        }
        
        while(i < n) {
            count++;
            if(count == k) return arr1[i];
            i++;
        }
        
        while(j < m) {
            count++;
            if(count == k) return arr2[j];
            j++;
        }
        
        return -1;
    }