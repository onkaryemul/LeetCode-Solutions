class Solution {
    
    // TC : O(n * log(sum(nums) - max(nums)))
    // SC : O(1)
    
    
    // Binary Search
    // Similar to Books allocation & Painter partition's problem
    
    
    // Split nums[] into k non-empty subarrays such that largest sum of any subarray is minimized
    // min(max subarray sum)
    public int splitArray(int[] nums, int k) {
        long low = getMax(nums);
        long high = getSum(nums);
        
        // apply binary search
        while(low <= high) {
            long mid = low + (high-low)/2;
            
            int cnt = countSubarrays(nums, mid);
            
            if(cnt > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return (int)low;
    }
    
    
    private int countSubarrays(int[] nums, long sum) {
        int cntSubarr = 1;
        long currSum = 0; 
        
        for(int i=0; i < nums.length; i++) {
            if(currSum + nums[i] <= sum) {
                currSum += nums[i]; // add the element to the current subarray
            }
            else {
                // add the element to the next subarray
                cntSubarr++;
                currSum = nums[i];
            }
        }
        
        return cntSubarr;
    }
    
    
    // Function to get maximum element from an array
    private long getMax(int[] nums) {
        long max = (long)nums[0];
        
        for(int i=1; i < nums.length; i++) {
            if(max < nums[i]) {
                max = (long)nums[i];
            }
        }
        
        return max;
    }
    
    // Function to get sum of all elements from an array
    private long getSum(int[] nums) {
        long sum = (long)nums[0];
        
        for(int i=1; i < nums.length; i++) {
            sum += (long)nums[i];
        }
        
        return sum;
    }
     
}

