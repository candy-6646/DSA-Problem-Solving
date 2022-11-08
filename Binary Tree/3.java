/* Postorder Traversal 

Iterative- We add node to st and go on left, once root == null, means not left node
            Now we just need to go right once
            Again when we encounter right == null, than we start to pop from st. and add to ans
*/
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversePost(root, ans);
        return ans;
    }
    
    void traversePost(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        
        traversePost(root.left, ans);
        traversePost(root.right, ans);
        ans.add(root.val);
    }
}