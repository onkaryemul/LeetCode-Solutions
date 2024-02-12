class Solution {
    
    // Moore's Voting Algorithm
    public int majorityElement(int[] nums) {
        
        int res = 0;
        int cnt = 1;
        
        
        for(int i=1; i < nums.length; i++) {
            if(nums[i] == nums[res]) {
                cnt++;
            } else {
                cnt--;
            }
            
            if(cnt == 0) {
                res = i;
                cnt = 1;
            }
        }

        
        int count = 0;
        
        for(int i=0; i < nums.length; i++) {
            if(nums[i] == nums[res]) {
                count++;
            }
        }
        
        
        if(count > nums.length / 2) {
            return nums[res];
        }
         
       
        return 0;
    }
    
}