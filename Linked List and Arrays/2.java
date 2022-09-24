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





/**************************Optimized in linear time solution**********************************/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        
        //inserting new Nodes in between original LL
        while(temp != null) {
            Node newNode = new Node(temp.val);
            
            Node next = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;
            temp = next;
        }
        
        //now setting random ptr of nodes
        temp = head;
        while(temp != null) {
            Node random = temp.random;
            if(random == null) {
                temp.next.random = null;
            }else
                temp.next.random = random.next;
            
            temp = temp.next.next;
        }
        
        //seperating Lists
        Node t1 = head;
        Node t2 = head.next;
        head = head.next;
        while(t1 != null) {
            t1.next = t1.next.next;
            if(t2.next != null)
                t2.next = t2.next.next;
            
            t1 = t1.next;
            t2 = t2.next;
        }
        
        return head;
    }
}