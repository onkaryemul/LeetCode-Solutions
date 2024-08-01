class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // 3 pointers approach
    public int removeDuplicates(int[] nums) {
        int oIndex = 0;
        int n = nums.length;
        
        int i = 0; // index upto which repetition happens
        
        while(i < n) {
            int sIndex = i; // start index of repetition
            
            while(i < n-1 && nums[i] == nums[i+1]) {
                i++;
            }
            
            int length = i - sIndex + 1; // length of repetition
            int freq = Math.min(length, 2);
            
            while(freq-- > 0) {
                nums[oIndex] = nums[sIndex];
                oIndex++;
            }
            
            i++;
        }
        
        return oIndex;
    }
    
}

