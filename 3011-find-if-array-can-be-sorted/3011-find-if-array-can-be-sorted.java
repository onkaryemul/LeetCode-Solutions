class Solution {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // Using Bubble sort 
    
    // function to check if we can sort the array 
    // given that we can swap any two adjacent elements if they have the same no. of set bits
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        
        boolean isSwapped = false;
        
        // apply bubble sort
        // for array of n elements ==> it takes (n-1) passes
        for(int i=0; i < n; i++) {
            isSwapped = false;
            
            // in every pass, the max element bubbles up to the rightmost index
            for(int j=0; j < n-i-1; j++) {
                if(nums[j] <= nums[j+1]) {
                    // no swap required
                    continue;
                }
                else { // swap is required ==> since nums[j] > nums[j+1]
                    // Check if both nums[j] & nums[j+1] have the same no. of set bits
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])) {
                        // if yes, swapping nums[j] & nums[j+1]
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        
                        
                        isSwapped = true;
                    }
                    else {
                        // not able to swap, hence we cannot sort the array
                        return false;
                    }
                }
            }
            
            // Check if no swapping was done in the pass, ==> hence "array was already sorted"
            if(isSwapped == false) {
                break; // break,  since "no more passes are required"
            }
        }
        
        return true;
    }
    
}

