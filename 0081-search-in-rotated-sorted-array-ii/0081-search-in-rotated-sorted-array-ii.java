class Solution {
    
    // N = size of the given array
    
    // TC : O(logN) -> for the best and average case --> binary search algorithm 
    //     O(N/2) -> for the worst case --> we continue to reduce the search space by adjusting the low & high pointers until they intersect
    
    // SC : O(1)
    
    // Using "Binary Search" in rotated sorted array    
    public boolean search(int[] nums, int target) {
        int n = nums.length; 
        
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // If mid points the target
            if(nums[mid] == target) {
                return true;
            }
            
            // Edge case (Very important)
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            
            // Check if the left part is sorted
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) { // target exists in left part
                    high = mid - 1;
                }
                else { // target does not exist in left part
                    low = mid + 1;
                }
            }
            else { // if right part is sorted
                if(nums[mid] <= target && target <= nums[high]) { // target exists in right part
                    low = mid + 1; 
                }
                else { // target does not exist in right part
                    high = mid - 1;
                }
            }
        }
        
        return false;
    }
    
}

