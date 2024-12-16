class Solution {
    
    // TC : O(n*logn + k*logn)
    // SC : O(n)
    
    // Using Min-Heap (PriorityQueue)
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        
        // Min-Heap
        // PriorityQueue to store pairs of (value, index) with a custom comparator
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        // Initialize the min heap with values and their indices
        for(int i=0; i < n; i++) {
            minHeap.offer(new int[] { nums[i], i });
        }
        
        // Perform k iterations
        while(k-- > 0) {
            // Extract the smallest element
            int[] temp = minHeap.poll();
            
            int number = temp[0];
            int idx = temp[1];
            
            // Update the array and reinsert the updated value into the heap
            nums[idx] = number * multiplier;
            
            minHeap.offer(new int[] { nums[idx], idx });
        }
        
        return nums;
    }
    
}


/*
// Approach-1 (Brute Force)
// T.C : O(n * k)
// S.C : O(1)

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            int idx = 0;

            // Find the index of the smallest element
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[idx]) {
                    idx = i;
                }
            }

            // Multiply the smallest element by the multiplier
            nums[idx] *= multiplier;
        }

        return nums;
    }
*/

