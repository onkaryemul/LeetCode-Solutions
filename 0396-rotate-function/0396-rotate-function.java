class Solution {
    
    public int maxRotateFunction(int[] nums) {
        int size = nums.length;
        
        int f0 = 0;
        int totalSum = 0;
        for(int i=0; i<size; i++) {
            f0 += (nums[i] * i);
            totalSum += nums[i];
        }
        
        int maxFn = f0, prevFn = f0;
        
        for(int i=size-1; i>=0; i--) {
            int num = nums[i];
            int nextFn = prevFn + totalSum - (size*num);
            
            maxFn = Math.max(maxFn, nextFn);
            
            prevFn = nextFn;
        }
        
        return maxFn;
    }
    
}

