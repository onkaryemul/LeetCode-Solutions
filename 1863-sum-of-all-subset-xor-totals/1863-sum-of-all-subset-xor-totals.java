class Solution {
    
    //T.C : O(n)
    //S.C : O(1)
    
    // Observing pattern
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int num : nums) {
            result |= num;
        }

        return result << (n - 1);
    }
    
}

