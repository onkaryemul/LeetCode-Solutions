class Solution {
    
    // TC : O(32 * log(num) * n) ~ O(n)
    // SC : O(32) ~ O(1)
    
    // Using Bit-Manipulation 
    // Using 2 pointers & sliding window approach
    
    // special array => bitwise OR of all of its elements is at least k
    
    // function to return the "length of the shortest special non-emepty subarray of nums", or return -1 if no special subarray exists
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        
        int[] bits = new int[32]; // To count each bit position
        
        int res = Integer.MAX_VALUE; // length of shortest special subarray
        
        // apply two pointers & sliding window approach
        int left = 0, right = 0;
        
        while(right < n) {
            // add the nums[right] to the current window
            addBits(nums[right], bits);
            
            // Check if bitwise OR of all elements in current window >= k
            // If yes, then shrink the window from the left while the condition is satisfied
            while(currentBitSum(bits) >= k && left <= right) {
                res = Math.min(res, right - left + 1);
                
                // remove (ie. substract) the nums[left] from the current window
                substractBits(nums[left], bits);
                
                left++;
            }
            
            right++;
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }    
    
   
    // Helper function => to add bits of a number to the bits count array
    private void addBits(int num, int[] bits) {
        int i = 0; // starting with 0th bit
        
        while(num > 0) {
            bits[i] += (num & 1);
            num = num >> 1;
            i++; 
        }
    }
    
    
    // Helper function => to substract bits of a number from the bits count array
    private void substractBits(int num, int[] bits) {
        int i = 0; //  starting with 0th bit
        
        while(num > 0) {
            bits[i] -= (num & 1);
            num = num >> 1;
            i++;
        }
    }
    
    
    // Helper function => to reconstruct the current bitwise OR value
    private int currentBitSum(int[] bits) {
        int result = 0;
        
        for(int i=0; i < 32; i++) {
            if(bits[i] > 0) {
                result = result | (1 << i);
            }
        }
        
        return result;
    }
    
    
}

