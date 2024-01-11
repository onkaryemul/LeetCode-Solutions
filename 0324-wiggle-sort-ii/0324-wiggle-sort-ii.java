class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    public void wiggleSort(int[] nums) {
        // Step 1: Sort the given array  --> O(n*logn)
        Arrays.sort(nums);
        
        int n = nums.length;
        
        // Step 2: Create an extra array of same size annd maintain the equivality in it
        int[] res = new int[n];
        
        int i = 1;
        int j = n-1;
        
        while(i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        
        i = 0;
        
        while(i < n) {
            res[i] = nums[j];
            i += 2;
            j--;
        }
        
        // Step 3: copy elements from res into input array
        for(i=0; i<n; i++) {
            nums[i] = res[i];
        }
    }
    
}

