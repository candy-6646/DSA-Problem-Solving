/*  Merge Two Sorted Lists */



class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode head = null;
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        }
        else {
            head = list2;
            list2 = list2.next;
        }
        
        ListNode ptr = head;
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
                ptr = ptr.next;
            }else {
                ptr.next = list2;
                list2 = list2.next;
                ptr = ptr.next;
            }
        }
        
        if(list1 == null) ptr.next = list2;
        
        if(list2 == null) ptr.next = list1;
        
        return head;
    }
}