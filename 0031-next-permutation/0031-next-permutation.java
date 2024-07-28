class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // In-place replacement algorithm
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i = n-1;
        int golaIndex = -1;
        
        // Iterate from right to left, check if if there exist an index i such that nums[i] > nums[i-1]
        for(i=n-1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                golaIndex = i-1;
                break;
            }
        }
        
        int swapIndex = -1;
        
        if(golaIndex >= 0) { // golaIndex should be greater than or equal to 0
            // Check from right to left, first element which is greater than nums[golaIndex] and return it index to swap
            for(int j=n-1; j > golaIndex; j--) {
                if(nums[j] > nums[golaIndex]) {
                    swapIndex = j;
                    break;
                }
            }
            
            swap(nums, golaIndex, swapIndex);
        }
        
        reverse(nums, golaIndex+1, n-1);
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
}

