class DSU {
    private int[] parent;
    private int[] rank;
    private int components;
    
    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        components = n;
        
        for(int i=1; i <= n; i++) {
            parent[i] = i;
        }
    }
    
    
    public int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        
        if(xParent == yParent) {
            return;
        }
        
        if(rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        }
        else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        }
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        
        components--;
    }
    
    
    public boolean isSingleComponent() {
        return components == 1;
    }
    
}



class Solution {
    
    // TC : O(m * logm) --> sorting edges
    //      O(m * α(n)) --> Union-find operations takes O(α(n)) time.
    //  The loop over all edges takes O(m) time, with each find and union operation inside the loop taking O(α(n)) time
    
    // SC : O(n)
    
    
    // Using DSU
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 1. Sort the edges array in descending order of type 
        Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        
        // 2. Create two separate DSU for Alice and Bob
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);
        
        int addedEdgeCnt = 0;
        
        for(int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if(type == 3) {
                boolean isAdded = false;
                
                // Alice
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    isAdded = true;
                }
                
                // Bob
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    isAdded = true;
                }
                
                if(isAdded) {
                    addedEdgeCnt++;
                }
            }
            else if (type == 2) { // Bob
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    addedEdgeCnt++;
                }
            }
            else { // Alice
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    addedEdgeCnt++;
                }
            }
        }
        
        if(Alice.isSingleComponent() && Bob.isSingleComponent()) {
            return edges.length - addedEdgeCnt; // maximum no. of edges that can be removed
        }
        
        return -1;
    }
    
}

