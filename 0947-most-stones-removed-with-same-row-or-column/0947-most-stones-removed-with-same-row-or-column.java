class Solution {
     
    // TC : O(n^2) * α(n)
    // SC : O(n)
    
    // Using DSU (Disjoint Set Union)
    
    private int[] parent;
    private int[] rank;
    private int n;
    
    
    // find function with path compression
    private int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]); // path compression
        }
        
        return parent[i];
    }
    
    
    // Union function with union by rank
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        if(rootI != rootJ) {
            if(rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } 
            else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            }
            else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }
    
    
    // Main function to return the largest possible no. of stones that can be removed
    public int removeStones(int[][] stones) {
        n = stones.length;
        
        parent = new int[n];
        rank = new int[n];
        
        // Initialize parent and rank arrays
        for(int i=0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        // Union stones that are in the same row or same column
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        
        // Count the no. of disjoint sets (connected components)
        int groups = 0;
        for(int i=0; i < n; i++) {
            if(parent[i] == i) {
                groups++;
            }
        }
        
        // No. of stones that can be removed = total stones - no. of groups
        return n - groups;
    }
    
}
