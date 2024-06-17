class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Two Pointer Approach
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        
        while(left <= right) {
            long total = (long)left * left + (long)right * right;
            
            if(total == c) {
                return true;
            }
            else if (total > c) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return false;
    }
    
}

