class Solution {
    
    // TC : O(m*m*n)
    // SC : O(n)
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of columns
        
        int[] summedRow = new int[n];
        int cnt = 0; // stores the count of submatrices whose sum equals target
        
        
        for(int i=0; i<m; i++) { // i is the starting row
            Arrays.fill(summedRow, 0);
            
            for(int j=i; j<m; j++) { // j is the ending row
                
                for(int k=0; k<n; k++) { // k is for column
                    summedRow[k] += matrix[j][k];
                }
                
                cnt += subarraySum(summedRow, target);
            }
        }
        
        
        return cnt;
    }
    
    
    // helper function
    private int subarraySum(int[] nums, int k) {
        int cnt = 0;
        
        // Key: prefixSum   Value: frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int currSum = 0;
        
        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];
            
            if(map.containsKey(currSum - k)) {
                cnt += map.get(currSum - k);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return cnt;
    }
}


