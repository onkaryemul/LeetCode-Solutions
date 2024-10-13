class Solution {
    
    // TC : O(n*k*logk)
    // SC : O(k)
    
    // Using Greedy approach => by using Min-Heap (PriorityQueue)
    
    private static int MIN_VAL = -1_000_000; // -10^6
    private static int MAX_VAL = 1_000_000; // 10^6
    
    
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size(); // no. of lists
        
        // Initial range values
        int rangeMin = MIN_VAL;
        int rangeMax = MAX_VAL;
        
        // Track the maximum value in the current window
        int currentMax = MIN_VAL;
        
        // Min-Heap (PriorityQueue) to track the smallest element across lists
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        // Initialize the minHeap with the first element of each list
        for(int i=0; i < k; i++) {
            minHeap.offer(new int[] { nums.get(i).get(0), i, 0 });
            currentMax = Math.max(currentMax, nums.get(i).get(0));
        }
        
        // Process elements in the minHeap while it is valid
        while(minHeap.size() == k) {
            int[] smallestElement = minHeap.poll();
            
            int value = smallestElement[0];
            int listIndex = smallestElement[1];
            int numIndex = smallestElement[2];
            
            // Update the range if the current one is smaller
            if(currentMax - value < rangeMax - rangeMin) {
                rangeMin = value;
                rangeMax = currentMax;
            }
            
            // Move to the next element in the list
            if(numIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(numIndex + 1);
                minHeap.offer(new int[]{ nextValue, listIndex, numIndex + 1});
                currentMax = Math.max(currentMax, nextValue);
            }
        }
        
        // return the smallest range found
        return new int[] { rangeMin, rangeMax };
    }
    
}

