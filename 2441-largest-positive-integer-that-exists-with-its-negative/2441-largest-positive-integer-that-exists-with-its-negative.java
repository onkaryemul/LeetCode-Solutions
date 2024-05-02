class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int findMaxK(int[] nums) {
        int res = -1;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i]>0 && set.contains(-nums[i]) && nums[i]>res) {
                res = nums[i];
            }
        }
        
        return res;
    }
}

