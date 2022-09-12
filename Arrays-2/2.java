/*
Merge Overlapping Sub-intervals

Two edge cases -
 [[1,4],[0,4]] -> output -> [[0,4]] (Sort on the basis of start)
 [[1,4],[2,3]] -> output -> [[1,4]] (2 and 3  < lastEnd) no need to add this interval[2, 3]
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ls.add(intervals[0][0]);
        ls.add(intervals[0][1]);
        lists.add(ls);
        
        int n = intervals.length;
        for(int i = 1; i < n; i++) {
            int lastEnd = lists.get(lists.size() - 1).get(1);
            
            if(intervals[i][0] <= lastEnd) {
                if(lastEnd < intervals[i][1]) {
                    lists.get(lists.size() - 1).set(1, intervals[i][1]);
                }
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                lists.add(list);
            }
        }
        
        int[][] arr = new int[lists.size()][2];
        for(int i = 0; i < lists.size(); i++) {
            arr[i][0] = lists.get(i).get(0);
            arr[i][1] = lists.get(i).get(1);
        }
        
        return arr;
    }
}