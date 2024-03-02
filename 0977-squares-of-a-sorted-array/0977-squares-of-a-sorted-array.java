class Solution {
    
    // Two-pointer Approach: 
    // TC : O(n)
    // SC : O(1)
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        
        for(int i=n-1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if(leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }
        
        return result;
    }
    
}

