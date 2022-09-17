/* Detect a Cycle in a Linked List 

Ist approach can be to use a  HashSet <Node> and add all nodes to it during traversal if the node
is found again in HashSet then it means it is a cycle;

Another approach is hare and tortoise as we know relative speed concept that if A is running 5km/h and b
is running 10km/h in a circular path then after a certain time B will meet A.
*/



static boolean cycleDetect(Node head) {
    if(head == null) return false;
    Node fast = head;
    Node slow = head;
        
    while(fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) return true;
    }
    return false;
}