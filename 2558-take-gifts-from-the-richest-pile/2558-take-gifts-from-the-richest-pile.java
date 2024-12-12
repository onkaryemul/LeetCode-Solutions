class Solution {
    
    // TC : O(n*logn + k*logn)
    // SC : O(n)
    
    // Using Max-Heap (PriorityQueue)
    
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int gift : gifts) {
            sum += gift;
            pq.add(gift);
        }
        
        long mySum = 0;
        
        while(k-- > 0) {
            int maxEl = pq.poll();
            
            int remaining = (int)Math.sqrt(maxEl);
            
            mySum += (maxEl - remaining);
            
            pq.offer(remaining);
        }
        
        return sum - mySum; // no. of remaining gifts ==> sum of the elements in the heap
    }
    
}

