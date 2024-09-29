/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */


// class Node --> for doubly-linked-list (DLL)
class Node {
    int freq;
    Set<String> strings;
    Node prev, next;
    
    // Constructor for Node, initializing frequency & linked list pointers
    public Node(int freq, Node prev, Node next) {
        this.freq = freq;
        this.strings = new HashSet<>();
        this.prev = prev;
        this.next = next;
    }
    
}



class AllOne {

    // TC : O(1)
    // SC : O(strings)
    
    private Node head, tail;
    private HashMap<String, Node> map;
    
    
    public AllOne() {
        // Sentinel nodes
        // head --> is for minimum frequency
        // tail --> is for maximum frequency
        head = new Node(Integer.MIN_VALUE, null, null);
        tail = new Node(Integer.MAX_VALUE, null, null);
        
        head.next = tail;
        tail.prev = head;
        
        // HashMap to map keys (strings) to their corresponding values(nodes)
        map = new HashMap<>();
    }
     
    // Helper function --> to remove a node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // O(1)
    public void inc(String key) {
        // Case : key(string) is not in the hash map (ie. it's a new key)
        if(!map.containsKey(key)) {
            // Check if No node with frequecy 1 exists right after the head node
            if(head.next.freq != 1) {
                // Create a new node with frequency 1 & insert it after head
                Node newNode = new Node(1, head, head.next);
                head.next.prev = newNode;
                head.next = newNode;
            } 
            
            // Add the new key(string) to the node with frequency 1
            head.next.strings.add(key);
            
            // Map the key(string) to this new node
            map.put(key, head.next);
        }
        else {
            // Case : key(string) exists in the map, so we increment its frequency
            Node node = map.get(key);
            
            // Remove the key(string) from its current frequency node
            node.strings.remove(key);
            
            int nextFreq = node.freq + 1;
            
            // Check if the next node has not the incremented frequency
            if(node.next.freq != nextFreq) {
                // No node exists with the new incremented frequency, so create one
                Node newNode = new Node(nextFreq, node, node.next);
                node.next.prev = newNode;
                node.next = newNode;
            }
            
            // Add the key(string) to the node with the incremented frequency
            node.next.strings.add(key);
            
            // update the map to point to the new frequency node
            map.put(key, node.next);
            
            // If the current node has no more keys(string), remove it from the linked list
            if(node.strings.isEmpty()) {
                removeNode(node);
            }
        }
    }
    
    // O(1)
    public void dec(String key) {
        Node node = map.get(key);
        
        // Remove the key(string) from its current frequency node
        node.strings.remove(key);
        
        // Case : If the frequency is 1, then we remove the key entirely
        if(node.freq == 1) {
            map.remove(key); // remove the key(string) from the map
        }
        else {
            int prevFreq = node.freq - 1;
            
            // Check if the previous node has not the decremented frequency
            if(node.prev.freq != prevFreq) {
                // No node exists with the decremented frequency, so create one
                Node newNode = new Node(prevFreq, node.prev, node);
                node.prev.next = newNode;
                node.prev = newNode;
            }
            
            // Add the key(string) to the node with the decremented frequency
            node.prev.strings.add(key);
            
            // update the map to point to the new frequency node
            map.put(key, node.prev);
        }
        
        // If the current node has no more keys, remove it from the linkedlist
        if(node.strings.isEmpty()) {
            removeNode(node);
        }
    }
    
    // O(1)
    public String getMaxKey() {
        // Case : The list is empty --> head is directly connected to tail
        if(tail.prev == head || head.next == tail) {
            return ""; // return an empty string if no keys are present
        }
        
        // Otherwise, return any key(string) from the set of the maximum frequency node
        Iterator<String> iterator = tail.prev.strings.iterator();
        
        return iterator.next(); 
    }
    
    // O(1)
    public String getMinKey() {
        // Case : If the list is empty --> head is directly connected to tail
        if(tail.prev == head || head.next == tail) {
            return ""; // return an empty string if no keys are present
        }
        
        // Otherwise, return any key(string) from the set of the minimum frequency node
        Iterator<String> iterator = head.next.strings.iterator();
        
        return iterator.next();
    }
    
}

