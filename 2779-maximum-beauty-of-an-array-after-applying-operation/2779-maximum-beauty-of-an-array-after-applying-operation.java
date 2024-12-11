class Solution {
    
    // TC : O(n*logn + n) ~ O(n*logn)
    // SC : O(1)
    
    // Using sorting => O(n*logn)
    // Using sliding window => O(n)
    
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        
        Arrays.sort(nums);
        
        // Sliding Window
        int maxCount = 0;
        
        int winCount = 0;
        
        int left = 0;
        int right = 0;
        
        while(right < n) {
            // Find valid window of max size
            while(right < n && (nums[right] - nums[left]) <= 2*k) {
                winCount++;
                right++;
            }
            
            maxCount = Math.max(maxCount, winCount);
            
            if(right == n) {
                break;
            }
            
            // Skip left to again make window valid
            while(left <= right && (nums[right] - nums[left]) > 2*k) {
                winCount--;
                left++;
            }
        }
        
        return maxCount;
    }
    
}

