class Solution {
    
    // TC : O(logn) 
    // SC : O(1)

    // Using Binary Search technique
    public int findMin(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        
        int n = nums.length;
        int low = 0, high = n-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // Check if search space is already sorted
            // then nums[low] will always be the minimum in that search space
            if(nums[low] <= nums[high]) {
                minElement = Math.min(minElement, nums[low]);
                break;
            }
            
            // Check if only left part is sorted
            if(nums[low] <= nums[mid]) {
                minElement = Math.min(minElement, nums[low]); // keep the minimum
                low = mid + 1; // eliminate the left half
            }
            else { // if right part is sorted --> nums[mid] <= nums[high]
                minElement = Math.min(minElement, nums[mid]); // keep the minimum
                high = mid - 1; // eliminate the right half
            }
        }
        
        return minElement;
    }
    
}

