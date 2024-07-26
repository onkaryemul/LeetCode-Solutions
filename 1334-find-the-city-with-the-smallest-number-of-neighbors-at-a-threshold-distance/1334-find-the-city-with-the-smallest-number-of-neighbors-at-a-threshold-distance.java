class Solution {
    
    // TC : O(n^3)
    // SC : O(n^2)
    
    // Floyd Warshall Algorithm
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cityNo = -1;
        int minCitiesCnt = n;
        
        int[][] dist = floydWarshall(n, edges, distanceThreshold);
        
        for(int city=0; city < n; city++) {
            int cnt = 0;
            
            for(int adjCity=0; adjCity < n; adjCity++) {
                if(dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }
            
            if(cnt <= minCitiesCnt) {
                minCitiesCnt = cnt;
                cityNo = city;
            }
        }
        
        return cityNo;
    }


    private int[][] floydWarshall(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for(int i=0; i < n; i++) {
            for(int j=0; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                }
                else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        
        for(int k=0; k < n; k++) {
            for(int i=0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE ||  dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        return dist;
    }
    
}
