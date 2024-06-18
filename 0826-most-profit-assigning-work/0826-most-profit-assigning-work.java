class Solution {
    
    // TC : O((n+m)*logn)
    // SC : O(1)
    
    // Sorting & Greedy Approach
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length; // n = profit.length
        int m = worker.length;
        
        // Create jobs array by pairing job's difficulty and profit and sort by difficulty
        int[][] jobs = new int[n][2];
        for(int i=0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // Sort the workers by their ability
        Arrays.sort(worker);
        
        // Maximize the profit for each worker according to their ability
        int totalProfit = 0;
        int maxProfit = 0;
        int jobIndex = 0;
        
        for(int i=0; i < m; i++) {
            // While current worker can do more difficulty jobs, update maxProfit
            while(jobIndex < n && worker[i] >= jobs[jobIndex][0]) {
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
    
}

