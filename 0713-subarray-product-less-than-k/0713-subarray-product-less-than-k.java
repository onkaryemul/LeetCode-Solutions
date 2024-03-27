class Solution {
    
    // Sliding window approach
    // TC : O(n) & SC : O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        
        int cnt = 0;
        int i, j; // i -> left pointer,  j -> right pointer
        
        int product = 1;
        
        for(i=0, j=0; j < n; j++) {
            product *= nums[j];
            
            while(product >= k && i < j) {
                product /= nums[i];
                i++;
            }
            
            if(product < k) {
                cnt += (j-i+1);
            }
        }
        
        return cnt;
    }
    
}

