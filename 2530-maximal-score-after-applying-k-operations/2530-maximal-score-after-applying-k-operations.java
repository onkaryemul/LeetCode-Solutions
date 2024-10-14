class Solution {
    
    // TC : O(n*logn + k*logn)
    // SC : O(n)
    
    // Using Greedy approach
    
    // Using Max-Heap (PriorityQueue)
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        
        long score = 0; // initially starting score is 0
        
        // Use a max-heap (priority queue with reverse order)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i < n; i++) {
            pq.add(nums[i]);
        }
        
        while(k-- > 0) {
            int maxEl = pq.poll();
            
            score += maxEl;
            
            // Add back the updated element
            maxEl = (int)Math.ceil(maxEl / 3.0);
            
            pq.add(maxEl);
        }
        
        return score;
    }
    
}

