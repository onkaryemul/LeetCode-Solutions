class Solution {
    
    // TC : O(max(l, log(n))), l = length of nums array
    // SC : O(1)
    
    // Greedy Observation
    public int minPatches(int[] nums, int n) {
        int patch = 0; // tracks minimum number of patches(addition) required
        
        long maxReach = 0;

        int i = 0;
        
        while(maxReach < n) {
            if(i < nums.length && nums[i] <= maxReach+1) {
                maxReach += nums[i];
                i++;
            }
            else { 
                maxReach += (maxReach + 1); // double each time, log(n) time complexity
                patch++;
            }
        }
        
        return patch;
    }
    
}

