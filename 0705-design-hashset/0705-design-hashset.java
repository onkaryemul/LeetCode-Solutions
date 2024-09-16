/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


class MyHashSet {
    // Separate Chaining -> Collision Handling Technique in Hashing
    
    // Approach : Using Buckets with Linked Lists
    // It uses a List of LinkedList to handle collisions
    // & can dynamically resize based on the load factor
    
    private static final int INITIAL_CAPACITY = 15000;
    
    private List<LinkedList<Integer>> buckets;
    private int numBuckets;
    private int size; // number of elements inserted into the set
    
    
    public MyHashSet() {
        numBuckets = INITIAL_CAPACITY;
        
        buckets = new ArrayList<>(numBuckets);
        
        for(int i=0; i < numBuckets; i++) {
            buckets.add(new LinkedList<>());
        }
        
        size = 0; // initially, zero (0) elements are inserted into the set
    }
    
    // Hash function
    private int getHashValue(int key) {
        return key % numBuckets;
    }
    
    // Resize function -> to resize data structure
    // When load_factor > 0.75
    private void resize() {
        int newCapacity = numBuckets * 2; // double the existing size of data structure
        
        List<LinkedList<Integer>> newBuckets = new ArrayList<>(newCapacity);
        for(int i=0; i < newCapacity; i++) {
            newBuckets.add(new LinkedList<>());
        }
        
        for(LinkedList<Integer> bucket : buckets) {
            for(int key : bucket) {
                int index = key % newCapacity;
                newBuckets.get(index).add(key);
            }
        }
        
        numBuckets = newCapacity;
        
        buckets = newBuckets;
    }
    
 
    public void add(int key) {
        int index = getHashValue(key);
        
        LinkedList<Integer> bucket = buckets.get(index);
        
        if(!bucket.contains(key)) {
            bucket.add(key);
            
            size++;
            
            // Resize if the load factor exceeds 0.75
            if((1.0 * size) / numBuckets > 0.75) {
                resize();
            }
        }
    }

    
    public void remove(int key) {
        int index = getHashValue(key);
        
        LinkedList<Integer> bucket = buckets.get(index);
        
        if(bucket.remove((Integer)key)) {
            size--;
        }
    }
    
    
    public boolean contains(int key) {
        int index = getHashValue(key);
        
        LinkedList<Integer> bucket = buckets.get(index);
        
        return bucket.contains((Integer)key);
    }
    
}

