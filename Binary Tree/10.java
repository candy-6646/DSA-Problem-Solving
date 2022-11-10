/* Vertical Order Traversal of Binary Tree 

Approach is we will use a var-diagonal and put the values inside the list of treeMap
But here is an edge case that nodes on same horizontal level & vertical level should be sorted
So,instead of using TreeMap<int, list> we will use TreeMap<int, Trremap<int, list>>.
upper level map will take care of diameter(horizontal lv.) and the second to keep track of Vertical Lv.

*/


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm = new TreeMap<>();
        
        helper(root, hm, 0, 0);
        for(Integer x: hm.keySet()) {
            
            TreeMap<Integer, List<Integer>> lvMap = hm.get(x);
            List<Integer> list = new ArrayList<>();
            
            for(Integer y: lvMap.keySet()) {
                List<Integer> temp = lvMap.get(y);
                Collections.sort(temp);
                for(int i = 0; i < temp.size(); i++) list.add(temp.get(i));
            }
            
            ans.add(list);
        }
        return ans;
    }

    void helper(TreeNode root, TreeMap<Integer, TreeMap<Integer, List<Integer>>> hm, int lv, int d) {
        if(root == null) return;
        
        if(!hm.containsKey(d)) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            
            TreeMap<Integer, List<Integer>> lvMap = new TreeMap<>();
            lvMap.put(lv, list);
            hm.put(d, lvMap);
        }else if(!hm.get(d).containsKey(lv)){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            
            TreeMap<Integer, List<Integer>> lvMap = hm.get(d);
            lvMap.put(lv, list);
        }else {
            hm.get(d).get(lv).add(root.val);
        }
        
        helper(root.left, hm, lv+1, d-1);
        helper(root.right, hm, lv+1, d+1);
    }
}