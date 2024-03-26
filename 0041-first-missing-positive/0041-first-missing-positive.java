class Solution {
    
    // TC : O(n)
    // SC : O(1)
    public int firstMissingPositive(int[] nums) {
        // Using Cycle sort -> TC: O(n) and SC: O(1)
        int n = nums.length;
        
        int i = 0;
        
        while(i < n) {
            int correctIndex = nums[i] - 1;
            
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        
        // Re-iterate through loop and check nums[i] == i+1, for orderly arrangement of positive numbers
        for(i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                return i + 1;  // return first missing positive number
            }
        }
        
        return n+1; // if all numbers are present, then return (n+1)th number as the first missing positive number
    }
    
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    
}




