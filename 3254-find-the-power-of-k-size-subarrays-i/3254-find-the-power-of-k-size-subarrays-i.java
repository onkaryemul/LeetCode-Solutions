class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using 2-pointers & Sliding Window Technique
    
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        
        int[] result = new int[n-k+1];
        // Initialise the result[] with -1
        Arrays.fill(result, -1);
        
        int cnt = 1; // Count of consecutive elements
        
        // Preprocess the first window
        for(int i=1; i < k; i++) {
            if(nums[i] == nums[i-1] + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
        }
        
        // Check if the first window satisfies the condition
        if(cnt == k) {
            result[0] = nums[k-1];
        }
        
        int i = 1;
        int j = k;
        
        // Process the sliding window
        while(j < n) {
            if(nums[j] == nums[j-1] + 1) {
                cnt++;
            } else {
                cnt = 1;
            }
            
            if(cnt >= k) {
                result[i] = nums[j];
            }
            
            i++;
            j++;
        }
        
        return result;
    }
    
}


/*
//Approach-2 (Using monotonic deque)
//T.C : O(n)
//S.C : O(n)

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deq = new LinkedList<>(); // Monotonic deque
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int j = 0; j < n; j++) {
            // If deque size equals k, remove the front element
            if (deq.size() == k) {
                deq.pollFirst();
            }

            // If deque is not empty and current element is not consecutive to the last element
            if (!deq.isEmpty() && deq.peekLast() != nums[j] - 1) {
                deq.clear();
            }

            // Add the current element to the deque
            deq.offerLast(nums[j]);

            // Once we process the first k elements
            if (j >= k - 1) {
                if (deq.size() == k) {
                    result[index++] = deq.peekLast(); // Last element is the max due to monotonic property
                } else {
                    result[index++] = -1; // Otherwise, add -1
                }
            }
        }

        return result;
    }
*/

