class Solution {
    
    public int minMoves2(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            moves += (nums[end]-nums[start]);
            
            start++;
            end--;
        }
        
        return moves;
    }
    
}

