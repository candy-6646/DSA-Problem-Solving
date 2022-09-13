/* Middle of the Linked List

brute force-> find size of LL then go upto n / 2; 

optimised is [Efficient] Tortoise-Hare-Approach
This approach is also useful in detecting cycles in LL

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // int size = getLLSize(head);
        // int mid = size / 2;
        // ListNode temp = head;
        // while(mid-->0) {
        //     temp = temp.next;
        // }
        
        return middle(head);
    }
    
    //[Efficient] Tortoise-Hare-Approach
    public static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static int getLLSize(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}