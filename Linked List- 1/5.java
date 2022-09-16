/* Add Two Numbers 

O(max(m,n)). The length of the new list is at most max(m,n)+1.
*/


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode newNode = new ListNode(sum);
            temp.next = newNode;
            temp = newNode;
        }
        
        if(carry >= 1) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        
        return dummy.next;
    }
}