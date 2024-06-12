class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Follow up: One-pass algorithm using only constant extra space
    public void sortColors(int[] nums) {
        int n = nums.length;
        
        int i = 0; // denotes for 0
        int j = 0; // denotes for 1
        int k = n-1; // denotes for 2
        
        while(j <= k) {
            if(nums[j] == 1) {
                j++;
            }   
            else if (nums[j] == 2) { // swap(nums[j], nums[k])
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                
                k--;
            }
            else { // nums[j] == 0
                // swap(nums[j], nums[i])
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                
                i++;
                j++;
            }
        }
    }
    
}

