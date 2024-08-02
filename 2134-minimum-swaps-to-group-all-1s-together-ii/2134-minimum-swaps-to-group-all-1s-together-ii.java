class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Sliding Window technique without extra space
    public int minSwaps(int[] nums) {
        // Binary circular array
        int n = nums.length;
        
        int countOnes = 0;
        for(int i=0; i < n; i++) {
            countOnes += nums[i]; // since array only contains 0 and 1, it will give us count of 1's
        }
        
        int i = 0, j = 0; // 2 pointers for sliding window
        
        int maxCountOne = 0;
        int currCount = 0;
        
        while(j < 2*n) {
            if(nums[j%n] == 1) {
                currCount++;
            }
            
            if(j-i+1 > countOnes) {
                currCount -= nums[i%n];
                i++;
            }
            
            maxCountOne = Math.max(maxCountOne, currCount);
            
            j++;
        }
        
        return countOnes - maxCountOne;
    }
    
}

