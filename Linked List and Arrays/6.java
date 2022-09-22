/* Max Consecutive Ones */

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if(n < 3) return ans;
        Arrays.sort(arr);
        for(int i = 0; i < n - 2; i++) {
            for(int j = i+1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == 0) {
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(arr[k]);
                        ans.add(ls);
                    }
                }
            }
        }
        
        return ans;
    }
}