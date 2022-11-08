/* Preorder Traversal 

Iterative- Add curr to ans and if curr.right != null add it to st and go on left
once left == null, pick ele from top of st
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { 
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Stack<TreeNode> st = new Stack<>();
        while(root != null) {
            ans.add(root.val);
            if(root.right != null) st.push(root.right);
            if(root.left != null) root = root.left;
            else root = !st.empty() ? st.pop():null;
        }
        return ans;
    }
}