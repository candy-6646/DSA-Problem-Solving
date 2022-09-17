/* Starting point of loop in a Linked List 

Brute force is to use HashSet

optimised- fast and slow ptr appraoch
    ex- 1 2 3 4 and cycle is from 4->2
    Steps:-
        first find the cycle
        cycle found at 4->2
        now suppose distance b/w 1 to 2 is l1
        and length of cycle = c (2->3->4->2->......)
        and distance from cycle starting pt to the pt where slow and fast collided is l2

        so slow just covered l1 + l2 distance to reach at collide pt.
        but fast travelled l1 + n*c + l2 distance to reach at collide pt. where(nc is some number of cycles)

        As we know fast travels double distance than slow
            2(l1 + l2) = l1 + l2 + nc
            l1 + l2 = nc
            (l1 = nc - l2)

            as dummy is starting from head, so it will also cover l1 distance to reach starting pt. of loop
            slow already travelled l1 + l2 now nc ~ l1, so dummy and slow will collide at a pt. return that Node.    
*/





public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == head) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(slow != dummy) {
                    slow = slow.next;
                    dummy = dummy.next;
                }
                return slow;
            }
        }
          
        return null;
    }
}