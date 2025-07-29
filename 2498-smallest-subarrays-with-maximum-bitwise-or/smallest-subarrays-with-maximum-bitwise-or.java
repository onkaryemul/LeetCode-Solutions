class Solution {
    
    // TC : O(n*32) ~ O(n)
    // SC : O(32) ~ O(1)

    // Approach => Traverse from right to left and check if kth bit of that number is set
    // Using frequency count and OR property

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] minSizeSubarrays = new int[n];
        
        int[] setBitIndex = new int[32];
        Arrays.fill(setBitIndex, -1);

        // Traverse from right to left
        for(int i=n-1; i >= 0; i--) {
            int endIndex = i;

            // Check if jth bit of nums[i] is set or not
            for(int j=0; j < 32; j++) {
                if((nums[i] & (1 << j)) == 0) { // means, jth bit is not set
                    if(setBitIndex[j] != -1) {
                        endIndex = Math.max(endIndex, setBitIndex[j]);
                    }
                }
                else { // means, jth bit is set
                    setBitIndex[j] = i;
                }
            }
 
            minSizeSubarrays[i] = endIndex - i + 1;
        }

        return minSizeSubarrays;
    }
}
