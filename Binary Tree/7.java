/* Bottom View of Binary Tree

Intiution is doing level order and every time node with a new horizontal level will be inseted and
updating already existing nodes
*/


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            int n = q.size();
            
            for(int i = 0; i < n; i++) {
                Pair curr = q.poll();
                hm.put(curr.dia, curr.node.data);
                
                if(curr.node.left != null) q.add(new Pair(curr.node.left, curr.dia-1));
                if(curr.node.right != null) q.add(new Pair(curr.node.right, curr.dia+1));
            }
        }
        
        for(int x: hm.keySet()) {
            ans.add(hm.get(x));
        }
        
        return ans;
    }
}

class Pair {
    Node node;
    int dia;
    
    Pair(Node n, int d) {
        node = n;
        dia = d;
    }
}