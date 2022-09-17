/* Intersection of Two Linked Lists 


App. - 1 -> Use two Queue's and add both LL ele in queue's and then remove ele from both of them until 
there sizes are equal, then remove ele from queue again until peek1 != peek();
if(queue size == 0) then no intersection else return peek();

Another optimised app. is that find the abs diff.in sizes of LL now if make temp ptr on correct pos
in the LL whose size if greater. Now start traversal then find intersection or return null;
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int sizeA = 0;
        while(temp1 != null){
            temp1 = temp1.next;
            sizeA++;
        }
        ListNode temp2 = headB;
        int sizeB = 0;
        while(temp2 != null){
            temp2 = temp2.next;
            sizeB++;
        }
        
        int diff = Math.abs(sizeA - sizeB);
        temp1 = headA;
        temp2 = headB;
        if(sizeA > sizeB){
            while(diff > 0){
                temp1 = temp1.next;
                diff --;
            }
        }else if(sizeB > sizeA){
            while(diff > 0){
                temp2 = temp2.next;
                 diff --;
            }
        }
        
        while(temp1 != null && temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
        
    }
}