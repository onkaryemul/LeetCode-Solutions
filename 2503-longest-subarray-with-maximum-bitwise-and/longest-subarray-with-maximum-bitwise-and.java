class Solution {
    
    // TC : O(n), single pass solution
    // SC : O(1)

    // Using Simple Observation of Bitwise & property
    // ie. Bitwise & of two numbers is always less than or equal to min. of two numbers
    // Hence, simple approach is to get the maximum value from an array => which is obviously the maximum Bitwise & 
    // So, we need to get the longest subarray of maximum value => length of max streak of max value

    public int longestSubarray(int[] nums) {
        int max = 0;
        int result = 0;
        int streak = 0;

        for(int num : nums) {
            if(num > max) {
                max = num;
                result = 0;
                streak = 0;
            }

            if(num == max) {
                streak++;
            }
            else {
                streak = 0;
            }

            result = Math.max(result, streak);
        }

        return result;
    }

}
