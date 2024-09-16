/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


class MyHashMap {
    
    // Use of "Separate Chaining" -> Collision Handling technique in Hashing
    
    private List<Pair>[] buckets;
    private int size = 15000;
    
    // Custom Pair class to store data in the form of <key, value>
    private static class Pair {
        int key;
        int value;
        
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    
    public MyHashMap() {
        buckets = new LinkedList[size];
        for(int i=0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    
    // Worst case -> O(size),  Ammortized - O(1)
    public void put(int key, int value) { 
        int bucketNo = key % size;
        
        List<Pair> chain = buckets[bucketNo];
        
        for(Pair pair : chain) {
            if(pair.key == key) { 
                pair.value = value; // update the value of existing key
                return;
            }
        }
        
        chain.add(new Pair(key, value));
    }
    
    
    // Worst case -> O(size),  Ammortized - O(1)
    public int get(int key) {
        int bucketNo = key % size;
        
        List<Pair> chain = buckets[bucketNo];
        
        for(Pair pair : chain) {
            if(pair.key == key) { // found the matching key
                return pair.value; 
            }
        }
        
        return -1; // not found
    }
    
    
    // Wort case -> O(size),  Ammortized - O(1)
    public void remove(int key) {
        int bucketNo = key % size;
        
        List<Pair> chain = buckets[bucketNo];
        
        for(Pair pair : chain) {
            if(pair.key == key) { // If found existing key which matches input key,
                chain.remove(pair); // remove that pair with key from chain
                return;
            }
        }
    }
    
}

