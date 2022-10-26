/* LRU cache 

Brute Force- Used two Queue's
    PUT- check if key already exists then move it to end of Queue(means least used key is on top of Q)
        if(cap == size) then remove q.peek()
        then put new (k,v) pair and add key also in Q


    Get - if key exists then find that key in Q and move to end
        then return key val


Optimised Approach is using DoublyLL

*/




class Node {
    int value;
    int key;
    Node prev;
    Node next;
    
    Node(int k, int v) {
        key = k;
        value = v;
        prev = null;
        next = null;
    }
}
/* head.next will point the recently used Node and tail prev will point to least used node*/
class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> hm;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int val = -1;
        if(hm.containsKey(key)) {
            Node curr = hm.get(key);
            val = curr.value;
            
            //deleting that node
            remove(curr);
            
            //adding it next to head
            insert(key, val);
        }
        
        return val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            remove(hm.get(key));
        }
        
        if(capacity == hm.size()) {
            remove(tail.prev);
        }
       
        insert(key, value);
    }
    
    private void remove(Node node) {
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(int key, int value) {
        Node n = new Node(key, value);
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
        
        hm.put(key, n);
    }
}
