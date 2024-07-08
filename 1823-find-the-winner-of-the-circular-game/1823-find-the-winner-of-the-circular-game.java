class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Queue-based approach
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i <= n; i++) {
            queue.offer(i);
        }
        
        while(queue.size() != 1) {
            for(int i=1; i <= k-1; i++) {
                queue.offer(queue.poll());
            }
            // kth element
            queue.poll();
        }
        
        return queue.poll();
    }
    
}

