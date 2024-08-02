class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public boolean canAliceWin(int[] nums) {
        int n = nums.length;
        int singleDigitSum = 0, doubleDigitSum = 0;
        
        for(int i=0; i < n; i++) {
            if(nums[i] < 10) { // single digit number
                singleDigitSum += nums[i];
            }
            else { // >= 10, double digit number
                doubleDigitSum += nums[i];
            }
        }
        
        return (singleDigitSum != doubleDigitSum) ? true : false;
    }
    
}

