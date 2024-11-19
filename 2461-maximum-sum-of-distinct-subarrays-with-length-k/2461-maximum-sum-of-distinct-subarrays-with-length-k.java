class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using 2-pointers & Sliding window technique
    // Using Set => to keep track of distinct elements in current window
    
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        long result = 0;
        
        // apply sliding window approach
        int i = 0;
        int j = 0;
        
        long currWindowSum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while(j < n) {
            // Adjust the window if nums[j] is already in the set
            while(set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        
            currWindowSum += nums[j];
            set.add(nums[j]);
            
            // Check if the window size is equal to k
            if(j - i + 1 == k) {
                result = Math.max(result, currWindowSum);
                
                // Shrink the window from the left
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            
            j++;
        }
        
        return result;
    }
    
}

