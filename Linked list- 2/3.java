/* Reverse Nodes in k-Group */


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //no need to reverse
        if(k == 1) return head;
        
        int n = size(head);
        //to get the head val after first reversal
        ListNode newHead = null;
        ListNode temp = head;
        //stores the tail of k size reversed list
        ListNode prevTail = null;
        while(n - k >= 0) {
            //taking refernce of next after k elements
            int oper = k;
            ListNode next = temp;
            while(oper-- > 0) {
                next = next.next;
            }
            
            //reverse of k ele
            ListNode revHead = reverse(temp, k-1);
            
            //setting newHead after first reversal
            if(newHead == null) newHead = revHead;
            
            //to get tail of reversed list so that use is for next time
            //in prevTail to attach newrevHead
            //also helping currently to attach remaining elements at end of revList
            ListNode ptr = revHead;
            while(ptr.next != null) {
                ptr = ptr.next;
            }
            if(prevTail == null) {
                prevTail = ptr;
            }else {
                prevTail.next = revHead;
                prevTail = ptr;
            }
            ptr.next = next;
            temp = next;
            n = n - k;
        }
        
        if(newHead == null) newHead = head;
        return newHead;
        
    }
    
    public static ListNode reverse(ListNode head, int k) {
        if(k == 0) return head;
        
        ListNode curr = reverse(head.next, k-1);
        head.next.next = head;
        head.next = null;
        return curr;
        
    }
    
    public static int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}