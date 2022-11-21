/* Maximum Width of a Binary Tree */

/*
Approach is that we will visit every node in level order traversal and assign idx to every node
for root node idx = 0 and for it's left child idx is 2*root_idx + 1 and for right child 2*root_idx+2

ans = rightmost_idx - leftmost_idx + 1;
 */
class Pair {
    TreeNode node;
    int nodeNumber;
    Pair(TreeNode t, int d) {
        node = t;
        nodeNumber =d;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxDia = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int n = q.size();
            int left = 0;
            int right = 0;
            for(int i = 0; i < n; i++) {
                Pair p = q.poll();
                System.out.println(p.node.val+" " + p.nodeNumber);
                
                //n == 1 means dia is one
                if(n > 1) {
                    if(i == 0) left = p.nodeNumber;
                    if(i == n-1) right = p.nodeNumber;
                }
                if(p.node.left != null) q.add(new Pair(p.node.left, 2*(p.nodeNumber) + 1));
                if(p.node.right != null) q.add(new Pair(p.node.right, 2*(p.nodeNumber) + 2));
            }
            
            maxDia = Math.max((right - left) + 1, maxDia);
        }
        
        return maxDia;
    }
}