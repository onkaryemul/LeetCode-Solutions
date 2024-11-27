class Solution {
    
    //T.C : O(q * (E log(V)) , V = number of vertices and E = number of edges
    //S.C : O(V+E)
    
    //Approach-2 (Using BFS (edges are unweighted)
    
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[n];
        
        queue.offer(0);
        
        visited[0] = true;

        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int node = queue.poll();

                if (node == n - 1) {
                    return level; // Found the destination node
                }

                for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            
            level++;
        }
        
        return -1; // If destination node is unreachable
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();

        // Initialize adjacency list with direct edges (i -> i + 1)
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        int k = queries.length;
        
        int[] res = new int[k];
        
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
            
            res[i] = bfs(n);
        }

        return res;
    }
    
}


/*
//Approach-1 - Using Dijkstra's Algorothm - Assuming each edge weight is 1
//T.C : O(q * (V+E)) , V = number of vertices and E = number of edges
//S.C : O(V+E)
class Solution {
    private Map<Integer, List<int[]>> adj = new HashMap<>();

    private int dijkstra(int n) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            if (node == n - 1) {
                return result[n - 1];
            }

            if (d > result[node]) {
                continue;
            }

            if (!adj.containsKey(node)) {
                continue;
            }

            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0];
                int dist = edge[1];
                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new int[]{d + dist, adjNode});
                }
            }
        }

        return result[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the adjacency list with the default edges
        for (int i = 0; i < n - 1; ++i) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{i + 1, 1});
        }

        int[] result = new int[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, 1});
            result[i] = dijkstra(n);
        }

        return result;
    }
}
*/

