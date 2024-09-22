class Solution {
    
    // TC : O(logn * logn)
    // SC : O(1)
    
    public int findKthNumber(int n, int k) {
        k--; // to make k as 0-based indexing
        
        long curr = 1;
        
        while(k > 0) {
            long cnt = countNodes(curr, n);
            
            if(k >= cnt) {
                curr++;
                k -= cnt;
            }
            else {
                curr *= 10;
                k--;
            }
        }
        
        return (int)curr;
    }
    
    
    // Helper function
    private long countNodes(long curr, int n) {
        long nextNode = curr + 1;
        
        long cnt = 0;
        
        while(curr <= n) {
            cnt += Math.min(n - curr + 1, nextNode - curr);
            curr *= 10;
            nextNode *= 10;
        }
        
        return cnt;
    }
    
}

