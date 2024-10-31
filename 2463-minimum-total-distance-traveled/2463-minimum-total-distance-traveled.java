class Solution {
    
    // TC : O(m*n), where m = no. of robots, n = no. of factories
    // SC : O(m*n)
    
    // Using Dynamic Programming
    // Using Recursion + Memoization
    
    private static final long MAX = 10000000000000L;
    
    // function to return the minimum total distance traveled by all the robots
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // 1. Sort the robots list based on position
        Collections.sort(robot);
        
        // 2. Sort the factory 2d array based on factory position
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        
        // 3. Convert multi-instance factory to single instance
        List<Integer> factories = new ArrayList<>();
        
        for(int[] fact : factory) {
            int pos = fact[0];
            int count = fact[1];
            
            for(int i=1; i <= count; i++) {
                factories.add(pos);
            }
        }
        
        // 4. Create a 2D Memoization table
        int m = robot.size();
        int n = factories.size();
        
        long[][] dp = new long[m][n];
        for(long[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        
        // 5. Call the helper function 
        return minDist(robot, m-1, factories, n-1, dp);    
    }
    
    
    // Helper function => Recursion + Memoization 
    private long minDist(List<Integer> robot, int roboPos, List<Integer> factories, int factPos, long[][] dp) {
        // Base case 
        if(roboPos < 0) { // It means that all robots have been repaired
            return 0;
        }
        
        if(factPos < 0) { // If some robots are left but factories are over
            return MAX;
        }
        
        // Check if already computed
        if(dp[roboPos][factPos] != -1) {
            return dp[roboPos][factPos];
        }
        
        // Take
        long include = Math.abs(robot.get(roboPos) - factories.get(factPos)) + minDist(robot, roboPos-1, factories, factPos-1, dp);
        
        // Not-take
        long exclude = minDist(robot, roboPos, factories, factPos - 1, dp);
        
        return dp[roboPos][factPos] = Math.min(include, exclude);
    }
    
    
}

