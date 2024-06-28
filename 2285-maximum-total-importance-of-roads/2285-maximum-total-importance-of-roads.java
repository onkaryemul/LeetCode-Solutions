class Solution {
    
    // TC : O(E + n*logn)
    // SC : O(n)
    
    // Greedy Approach:  Highest degree node --> Highest value is given to maximize importance
    public long maximumImportance(int n, int[][] roads) {
        // n = total number of nodes numbered from 0 to n-1
        int[] degree = new int[n];
        
        // Calculate the degree of each node
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            
            degree[u]++;
            degree[v]++;
        }
        
        // Sort the degrees in ascending order
        Arrays.sort(degree);
        
        long totalMaxImportance = 0;
        long value = 1;
        
        // Calculate the sum of degrees * values
        for(int i=0; i < n; i++) {
            totalMaxImportance += (degree[i] * value);
            value++;
        }
        
        return totalMaxImportance;
    }
    
}

