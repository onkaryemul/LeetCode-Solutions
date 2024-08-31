class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        
        for(int i=0; i < n; i++) {
            int num3 = nums[i];
            
            if(num3 <= num1) { // first ask num1
                num1 = num3;
            }
            else if(num3 <= num2) { // ask num2
                num2 = num3;
            }
            else { // num1 < num2, inki life set hai already
                return true;
            }
        }
        
        return false;
    }
  
}


/*   
// Using the concept of LIS(Longest Increasing Subsequence)

// TC : O(n^2)
// SC : O(n)

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // length of LIS at any index of nums[] is atleast 1 ie. element itself
        // dp[i] -> length of longest increasing subsequence till that index i
        
        int longestIncreasingSubsequence = 0;
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            
            longestIncreasingSubsequence = Math.max(longestIncreasingSubsequence, dp[i]);
            
            if(longestIncreasingSubsequence >= 3) {
                break;
            }
        }
    
        return longestIncreasingSubsequence >= 3 ? true : false;
    }
*/

