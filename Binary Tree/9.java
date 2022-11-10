/* Preorder inorder postorder in a single traversal */



public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        helper(root, pre, in, post);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
    
    static void helper(BinaryTreeNode<Integer> root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if(root == null) return;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.empty()) {
            Pair curr = st.pop();
            
            if(curr.lv == 1) {
                pre.add(curr.node.data);
                curr.lv = 2;
                st.push(curr);
                if(curr.node.left != null) st.push(new Pair(curr.node.left, 1));
            }else if(curr.lv == 2){
                in.add(curr.node.data);
                curr.lv = 3;
                st.push(curr);
                if(curr.node.right != null) st.push(new Pair(curr.node.right, 1));
            }else {
                post.add(curr.node.data);
            }
        }
    }
}

class Pair {
    int lv;
    BinaryTreeNode<Integer> node;
    Pair(BinaryTreeNode<Integer> n, int l) {
        lv = l;
        node = n;
    }
}
