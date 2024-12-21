class Solution {
    
    // n = number of nodes in the graph
    // m = number of edges in the graph
    
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)
    
    // Using Greedy approach
    // Using Greedy split
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] count = {0};
        
        dfs(adj, values, k, count, 0, -1);
        
        return count[0];
    }
    
    // Helper function
    // Depth first search (DFS) 
    private int dfs(List<List<Integer>> adj, int[] values, int k, int[] count, int curr, int parent) {
        long sum = values[curr];
        
        for (int nbr : adj.get(curr)) {
            if (nbr != parent) {
                sum += dfs(adj, values, k, count, nbr, curr);
            }
        }
        
        sum %= k;
        
        if (sum == 0) 
           count[0]++;
        
        return (int) sum;
    }
    
}

