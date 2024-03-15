class Solution {
    
    // TC : O(n)
    // SC : O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        for(int i=0, temp=1 ; i < nums.length; i++) {
            result[i] = temp; // temp -> left product sum
            temp *= nums[i];
        }
        
        for(int i=nums.length-1, temp=1; i >= 0; i--) {
            result[i] = result[i] * temp; // temp -> right product sum
            temp *= nums[i];
        }
        
        return result;
    }
    
}

