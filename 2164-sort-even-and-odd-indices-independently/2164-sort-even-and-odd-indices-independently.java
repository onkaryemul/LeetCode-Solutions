class Solution {
    
    // Using PriorityQueue (heap)     
    public int[] sortEvenOdd(int[] nums) {
        // maxHeap -> for odd indices -> decresing order (non-increasing)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b-a));
        // minHeap -> for even indices -> increasing order (non-decresing)
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> (a-b));
        
        int n = nums.length;
        
        for(int i=0; i < n; i+=2) { // even indices in minHeap (increasing order)
            minHeap.offer(nums[i]); 
        }
        
        for(int i=1; i < n; i+=2) { // odd indices in maxHeap (decreasing order)
            maxHeap.offer(nums[i]);
        }
        
        int i = 0;
        while(!minHeap.isEmpty()) { // minHeap -> even indices -> increasing order
            nums[i] = minHeap.poll();
            i += 2;
        }
        
        i = 1; 
        while(!maxHeap.isEmpty()) { // maxHeap -> odd indices -> decresing order
            nums[i] = maxHeap.poll();
            i += 2;
        }
        
        return nums;
    }
    
}

