class KthLargest {

    // TC : O(n*logk + m*logk)
    // SC : O(k)
    
    // Using Min-Heap (PriorityQueue)
    
    private PriorityQueue<Integer> pq;
    private int k;
    
    // O(n*logk)
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k); // by default, it is min-heap
        
        for(int num : nums) {
            pq.offer(num);
            
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    // O(m*logk)
    public int add(int val) {
        pq.offer(val);
        
        if(pq.size() > k) {
            pq.poll();
        }
        
        return pq.peek();
    }

}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

