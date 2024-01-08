// TC : O(n)
// SC : O(n)
class Solution {
    
    // recursive function
    private int solve(int n, int k) {
        // Base case
        if(n==1) {
            return 0;
        }
        
        return (solve(n-1, k) + k) % n;
    }
    
    // Main algorithm code
    public int findTheWinner(int n, int k) {
        int ans = solve(n, k) + 1;
        return ans;
    }
    
}
