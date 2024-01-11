class Solution {
    
    // TC : O(n*logk)
    // SC : O(n)
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        
        // Min-Heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((a, b) -> (a[0] - b[0]));
        
        // O(n*logk)
        for(int i=0; i<n; i++) { // O(n)
            pq.offer(new int[]{nums[i], i}); // logk
            if(pq.size() > k) {
                pq.poll(); // logk
            }
        }
        
        Set<Integer> index = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            index.add(top[1]);
        }
        
        
        int p=0;
        for(int i=0; i<n; i++) {
            if(index.contains(i)) {
                ans[p] = nums[i];
                p++;
            }
        }
        
        
        return ans;
    }
    
}


