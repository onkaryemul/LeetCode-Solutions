class Solution {
    
    // TC : O(n*logn + n + m*logn)
    // SC : O(1)
    
    // Using Greedy approach => using sorting
    // Using Prefix Sum approach => to store maximum beauty seen till that index
    // Using Binary Search => to find the rightmost index at which price <= query[i]
    
    // Simple Binary search & preprocessing
    
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        
        int[] result = new int[m];
        
        // Step 1 : Sort the items[][] based on the price in ascending order
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));
        
        // Step 2 : Update beauty values to make them non-decreasing 
        int maxBeautySeen = items[0][1];
        
        for(int i=1; i < n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }
        
        // Step 3 : Process each query using custom binary search
        for(int i=0; i < m; i++) {
            int queryPrice = queries[i];
            result[i] = customBinarySearch(items, queryPrice);
        }
        
        return result;
    }
    
    
    // Helper function => binary search 
    // to find the maximum beauty of items whose price <= queryPrice
    private int customBinarySearch(int[][] items, int queryPrice) {
        int left = 0;
        int right = items.length - 1;
        
        int maxBeauty = 0;
        
        // apply binary search
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(items[mid][0] > queryPrice) {
                right = mid - 1; // Move to the left side
            }
            else {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                left = mid + 1;
            }
        }
        
        return maxBeauty;
    }
    
}

