class Solution {
    
    // TC : O(log(num))
    // SC : O(1)
    
    // Using "Binary Search" on answers
    
    public boolean isPerfectSquare(int num) {
        // Base case
        if(num == 1) {
            return true;
        }
        
        int low = 1, high = num/2;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            long res = (long) mid * mid;
            
            if(res == num) {
                return true;
            }
            
            if(res < num) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }
    
}

