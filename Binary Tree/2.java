/* Preorder Traversal */

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