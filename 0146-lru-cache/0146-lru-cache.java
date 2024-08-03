class LRUCache {
    
    // Doubly Linked List Node
    class Node {
        int key, value;
        Node prev, next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    // Creating head and tail nodes of doubly linked list
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    // Creating HashMap 
    // key: key, Value: Reference of node with key
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    
    public int get(int key) {
        // Check if it is present in map
        if(map.containsKey(key)) {
            Node node = map.get(key);
            
            deleteNode(node);
            insertAfterHead(node);
            
            return node.value;
        }
        else {
            return -1;
        }
    }
   
    
    public void put(int key, int value) {
        // Check if already present
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            
            deleteNode(node);
            insertAfterHead(node);
        }
        else {
            if(map.size() == capacity) {
                Node beforeTailNode = tail.prev;
                
                deleteNode(beforeTailNode);
                
                Node node = new Node(key, value);
                insertAfterHead(node);
            }   
            else {
                Node node = new Node(key, value);
                insertAfterHead(node);
            }
        }
    }
    
    
    private void deleteNode(Node node) {
        map.remove(node.key);
        
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        prevNode.next = node.next;
        nextNode.prev = node.prev;
    }
    
    
    private void insertAfterHead(Node node) {
        map.put(node.key, node);
        
        Node nextToHead = head.next;
        
        node.next = nextToHead;
        nextToHead.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
