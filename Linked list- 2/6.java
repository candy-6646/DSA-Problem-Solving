/* Flattening of a LinkedList 

node.child or node.bottom is to traverse in sub-list
node.next is to go to another sublist

Brute force app.-> Added all in an arrayList then sorted the Al and changes each Al.child val.
*/



//**********************************BRUTE FORCE*****************************************************
class NodeComparator implements Comparator<Node> {
    // override the compare() method
    public int compare(Node s1, Node s2)
    {
        if (s1.data == s2.data)
            return 0;
        else if (s1.data > s2.data)
            return 1;
        else
            return -1;
    }
}

class GfG
{
    Node flatten(Node root)
    {
	    ArrayList<Node> al = new ArrayList<>();
	    Node temp = root;
        while(temp != null) {
            Node ptr = temp;
            while(ptr != null) {
                al.add(ptr);
                ptr = ptr.bottom;
            }
            temp = temp.next;
        }
        
        Node head = null;
        if(al.size() > 0) {
            Collections.sort(al, new NodeComparator());
            head = al.get(0);
            
            for(int i = 1; i < al.size(); i++) {
                al.get(i-1).bottom = al.get(i);
            }
            
            al.get(al.size()-1).bottom = null;
        }
        return head;
    }
}
















//*************************************MERGE ALGO************************************************
public class Solution {
	public static Node flattenLinkedList(Node start) {
		if(start == null || start.next == null) return start;
        start.next = flattenLinkedList(start.next);
        start = mergeTwoLists(start, start.next);
        
        return start;
	}
    static Node mergeTwoLists(Node a, Node b) {
        
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.child = a; 
                temp = temp.child; 
                a = a.child; 
            }
            else {
                temp.child = b;
                temp = temp.child; 
                b = b.child; 
            }
        }
        
        if(a != null) temp.child = a; 
        else temp.child = b;
        return res.child; 
    
    }
}