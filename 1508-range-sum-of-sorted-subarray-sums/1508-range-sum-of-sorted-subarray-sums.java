class Solution {
    
    // TC : O(n^2 * logn^2)
    // SC : O(n^2)
    
    // Brute force approach
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        
        int totalSubarrays = n*(n+1)/2;
        int[] subarraySums = new int[totalSubarrays];
        int idx = 0;
        
        for(int i=0; i < n; i++) {
            int sum = 0;
            for(int j=i; j < n; j++) {
                sum += nums[j];
                subarraySums[idx++] = sum;
            }
        }
        
        Arrays.sort(subarraySums);
        
        int resultSum = 0;
        for(int i = left-1; i < right; i++) {
            resultSum = (resultSum + subarraySums[i])%mod;
        }
        
        return resultSum;
    }
    
}

