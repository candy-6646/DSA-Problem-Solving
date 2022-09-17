/* Palindrome Linked List 

Brute force is to use stack

Optimized- find mid, reverse from mid.next to end
take dummy on head and temp on mid.next, and start comparing */


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        //finding midEle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reversing from mid.next to end
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        while(slow != null) {
            if(dummy.val != slow.val) return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}