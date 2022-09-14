/*  Design Linked List */
class Node {
    int val;
    Node next;
    public Node(){}
    public Node(int val) {
        this.val = val;
    }
}
class MyLinkedList {
    Node head, tail;
    int size = 0;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public int get(int index) {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            
            if(count == index) return temp.val;
            count++;
            temp = temp.next;
        }
        
        return -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) this.addAtTail(val);
        else if(index == 0) this.addAtHead(val);
        else {
            Node temp = head;
            while(index-1 > 0) {
                temp = temp.next;
                index--;
            }
            
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size-1) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        
        int idx = index;
 
        Node temp = head;
        while(index - 1 > 0) {
            temp = temp.next;
            index--;
        }
        if(idx == size - 1) tail = temp;
        temp.next = temp.next.next;
        size--;
    }
    
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}