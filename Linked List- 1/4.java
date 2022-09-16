/*
Remove N-th node from the end of a Linked List 

Brute force - find size and then go to (size - n - 1) to remove it. O(2n)

Optimised- Two PTR Approach, 
    We know, that the n-th node from the end is the same as (total nodes – n)th node from start.
    We take two pointers- fast and slow (start from one node previous of Head  dummy->head->.....)
    first we make sure that fast will point at nth node from start
    Ex- 1 2 3 4 5 and n - 2 (So we wnat to delete 4)
    fast = 2

    now once fast is fixed now time to make slow also on correct position
    start slow from head and go till fast.next != null;

    so,

    fast -> 5
    slow -> 3
    so slow reach at correct pos to delete 4
    Intuition- fast and slow it at gap n, so if fast is at end slow is at nth from end node
*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*int size = findSize(head);
        if(n == size) return head.next;
        
        ListNode temp = head;
        for(int i = 1; i <= (size - n - 1); i++) {
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        return head; */
        
        
        
        
        //Optimised approach
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
        
    }
    /*
    public static int findSize(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    } */
}