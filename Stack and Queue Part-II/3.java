/* LFU Cache 

So Approach is same like LRU cache but here we are also maintaing a freq. map
freq. map will gonna store list of ele having same freq in the LRU form.
We need to maintain a ptr of min.freq, so that we can remove the LFU item easily by getting its list
from freq. map, then removing it directly as it is a DLL node
*/

class Node {
    int key;
    int val;
    int freq;
    Node prev;
    Node next;
    
    Node(int k, int v) {
        key  = k;
        val = v;
        freq = 1;
        prev = null;
        next = null;
    }
}
//doubly linked list
class Dll {
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int size;
    Dll() {
        head.next = tail;
        tail.prev = head;
         size = 0;
    }
    
    //removes last element
    Node remove() {
        if(size >= 1) {
            Node rNode = tail.prev;
            rNode.prev.next = tail;
            tail.prev = rNode.prev;
            
            size--;
            
            return rNode;
        }
        return null;
    }
    
    void remove(Node node) {
        if(size >= 1) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            size--;
        }
    }
    
    Node insert(int key, int value, int freq) {
        Node n = new Node(key, value);
        n.freq = freq;
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
        
        size++;
        return n;
    }
}
class LFUCache {
    HashMap<Integer, Node> hm;
    HashMap<Integer, Dll> freqMap;
    int freq;
    int capacity;
    public LFUCache(int capacity) {
        hm = new HashMap<>();
        freqMap= new HashMap<>();
        freq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {
            Node curr = hm.get(key);
            Dll ls = freqMap.get(curr.freq);
            ls.remove(curr);
            
            if(!freqMap.containsKey(curr.freq+1)) {
                freqMap.put(curr.freq+1, new Dll());
            }
            
            Node n = freqMap.get(curr.freq+1).insert(key, curr.val, curr.freq+1);
            hm.put(key, n);
            
            if(freq == curr.freq && ls.size == 0) freq = curr.freq+1;
            
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(hm.containsKey(key)) {
            Node curr = hm.get(key);
            Dll ls = freqMap.get(curr.freq);
            ls.remove(curr);
            
            if(!freqMap.containsKey(curr.freq+1)) {
                freqMap.put(curr.freq+1, new Dll());
            }
            
            Node n = freqMap.get(curr.freq+1).insert(key, value, curr.freq+1);
            hm.put(key, n);
            
            if(freq == curr.freq && ls.size == 0) freq = curr.freq+1;
            
            return;
        }
        
        if(hm.size() == capacity) {
            Dll ls = freqMap.get(freq);
            Node rNode = ls.remove();
            hm.remove(rNode.key);
            
            freq = 1;
            if(!freqMap.containsKey(freq)) {
                freqMap.put(1, new Dll());
            }
            Node n = freqMap.get(1).insert(key, value, 1);
            
            hm.put(key, n);
            return;
        }
        freq = 1;
        if(!freqMap.containsKey(freq)) {
            freqMap.put(1, new Dll());
        }
        Node n = freqMap.get(1).insert(key, value, 1);
        hm.put(key, n);
        return;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */