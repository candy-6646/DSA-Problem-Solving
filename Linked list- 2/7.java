/* Swap Kth nodes from ends

One edge case not figured out now i.e., when k -> 1 or n

Ex- 123456 k-3 swap(3, 4) figured this case

what's the APP- just reaching last prev of each kth node then changing refernces

*/

 public static Node swapKthNodes(Node head, int k) {
        //for swapping node val use two ptr
        //first take a dummy to reach kthn node from start
        //now start ptr1 and do ptr1 = ptr1.next until dummy 
        //reaches end
        //place ptr2 at kthNode
        //then swap vals

            //these two nodes will point the prevNode of the kth Node
            Node ptr1 = head;
            for(int i = 1; i < k-1; i++) ptr1 = ptr1.next;
            
            Node dummy = head;
           for(int i = 0; i < k; i++) dummy = dummy.next;
            Node ptr2 = head;
            while(dummy.next != null) {
                    dummy = dummy.next;
                    ptr2 = ptr2.next;
            }

            //Actual kth nodes need to be swap
            Node nextPtr1 = ptr1.next;
            Node nextPtr2 = ptr2.next;

            //swapping next ref in both kth node
            Node temp = nextPtr1.next;
            nextPtr1.next = nextPtr2.next;
            nextPtr2.next = temp;

            //changing ref's of prev node to point new kth ele
            ptr1.next = nextPtr2;
            ptr2.next = nextPtr1;
            return head;
    }