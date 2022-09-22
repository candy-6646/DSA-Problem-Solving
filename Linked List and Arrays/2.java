/* Copy List with Random Pointer


*/



/******************************Brute force********************************/
class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node newHead = null;
        Node prev = null;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            
            if(newHead == null) {
                newHead = newNode;
                prev = newNode;
            }else {
                prev.next = newNode;
                prev = newNode;
            }
            temp = temp.next;
        }
        
        temp = head;
        Node temp2 = newHead;
        while(temp != null) {
            Node t1 = head;
            Node t2 = newHead;
            Node currRandom = temp.random;
            if(currRandom == null) temp2.random = null;
            else {
                while(t1 != currRandom) {
                    t1 = t1.next;
                    t2 = t2.next;
                }
                
                temp2.random = t2;
            }
            
            temp = temp.next;
            temp2 = temp2.next;
            
        }
        
        return newHead;
    }
}