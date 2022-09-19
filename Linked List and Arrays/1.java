/* Rotate List 

brute force - O(kn)

more optimised sol. can be
    Ex- [1,2,3,4,5], k = 2

    Instead of connecting head with tail for n times, directly get the (n-k)th node and then change ref.
    once.
    Ex- size -> 5 and k -> 2
    while computing size connect tail with head

    take two ptr to reach (n-k)th node,  prev->3 and curr->4
    prev.next = null;
    head = curr;
*/



class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int size = giveSize(head);
        k = k % size;
        while(k-->0) {
            ListNode tail = giveTail(head);
            //one node before tail
            ListNode prev = head;
            while(prev.next != tail) prev = prev.next;
            
            tail.next = head;
            head = tail;
            prev.next = null;
            tail = prev;
        }
        
        return head;
    }
    
    public static ListNode giveTail(ListNode head) {
        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        
        return temp;
    }
    
    public static int giveSize(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        
        return count;
    }
}