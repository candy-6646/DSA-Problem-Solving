/* Reverse Linked List
one thing about LL is to play with links
so to reverse we are just changing the references, next.next -> prev
*/


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode prev = head;
        ListNode next = head.next;
        head.next = null;
        while(next.next != null) {
            ListNode curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }
        
        next.next = prev;
        
        return prev;
        // return reverse(head);
    }
    
    //recursive solution
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode nextNode = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return nextNode;
    }
}
