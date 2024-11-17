class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using Prefix-Sum approach
    // Using ArrayDeque => Monotonic Deque => to store total sum in increasing order
    
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        
        // {index, prefixSum}
        ArrayDeque<long[]> window = new ArrayDeque<>();
        window.add(new long[]{-1, 0}); // -1 index, 0 prefixSum => initially
        
        long res = Integer.MAX_VALUE;
        
        long total = 0;
        
        for(int i=0; i < n; i++) {
            if(nums[i] >= k) {
                return 1;
            }
            
            total += nums[i];
            
            while(!window.isEmpty() && window.getLast()[1] >= total) {
                window.removeLast();
            }
            
            window.add(new long[] {i, total});
            
            while(window.size() >= 2 && window.getLast()[1] - window.getFirst()[1] >= k) {
                res = Math.min(res, window.getLast()[0] - window.getFirst()[0]);
                window.removeFirst();
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : (int)res;
    }
    
}

