class Solution {
    
    // TC : logN
    // SC : O(1)
    
    // Using "Binary Search" algorithm
    
    // Only one element appears exactly once, while all other elements appear exactly twice
    // function to return the "single element that appears only once"  
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length; 
        
        // Edge cases -> Very important
        if(n == 1) {
            return nums[0];
        }
        
        if(nums[0] != nums[1]) {
            return nums[0];
        }
        
        if(nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }
        
        // apply binary search
        int low = 1, high = n-2;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // Check if nums[mid] is the single element
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            
            // Check if we are in the left part
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) 
                  || (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
                low = mid + 1;
            }
            else { // else, we are in the right part
                high = mid - 1;
            }
        }
        
        return -1; // dummy return statement
    }
    
}

