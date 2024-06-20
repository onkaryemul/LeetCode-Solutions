class Solution {
    
    // TC : O(n*logn + logn), due to array sorting and binary search
    // SC : O(1)
    
    // Binary Search technique
    public int maxDistance(int[] position, int m) {
        // Step 1: Sort the position array for applying binary search
        Arrays.sort(position);
        
        int n = position.length;
        
        int left = 0; // Minimum Possible distance
        int right = position[n-1] - position[0]; // Maximum  Possible distance
        
        int ans = 0;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            // Check if the gap is sufficient for valid configuration of m balls
            if(isAnswer(position, mid, m)) {
                ans = mid; // if it is valid configuration, update answer
                left = mid + 1; //try for larger gap, for maximizing the minimum magnetic force
            }
            else {
                right = mid - 1; // reduce the gap size
            }
        }
        
        return ans;
    }
    
    
    private boolean isAnswer(int[] A, int mid, int m) {
        int placed = 1; // Greedily place the first ball at first position 
        int prev = A[0]; // prev pointer as the ball is being placed here
        
        int n = A.length;
        
        for(int i=1; i < n; i++) {
            // Check if the gap is sufficient enough, if yes, then place the ball
            if(A[i] - prev >= mid) {
                placed++; // increment the number of placeable balls
                prev = A[i]; // update the prev pointer
                
                // Check if all balls placed are equal to given m balls, if yes, then return true
                if(placed == m) {
                    return true; // indicating valid configuration
                }
            }
        }
        
        // Check if not all balls are placed
        if(placed < m) {
            return false; // can't place m balls with mid gap
        }
        
        return true;
    }
    
}


