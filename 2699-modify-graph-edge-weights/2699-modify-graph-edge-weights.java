class Solution {
    
    // TC : O((V + E*logV) * E)
    // SC : O(E + V)
    
    // Using Dijstra's algorithm
    
    private static int MAX = 2_000_000_000;
    Map<Integer, Map<Integer, Integer>> graph;
    
    
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        graph = new HashMap<>();
        
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int d = edge[2];
            
            if(d != -1) { // Ignoring -1 weight edges
                graph.computeIfAbsent(x, k -> new HashMap<>()).put(y, d);
                graph.computeIfAbsent(y, k -> new HashMap<>()).put(x, d);
            }
        }
        
        int currDistance = dijkstra(source, destination);
        
        if(currDistance < target) {
            return new int[0][0];
        }
        
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int d = edge[2];
            
            if(d != -1) { // ignoring all positive weighted edges
                continue;
            }
            
            if(currDistance == target) {
                edge[2] = MAX;
                continue;
            }
            
            edge[2] = 1;
            
            graph.computeIfAbsent(x, k -> new HashMap<>()).put(y, 1);
            graph.computeIfAbsent(y, k -> new HashMap<>()).put(x, 1);
            
            currDistance = dijkstra(source, destination);
            
            if(currDistance <= target) {
                edge[2] += target - currDistance;
                currDistance = target;
            }
        }
        
        return currDistance == target ? edges : new int[0][0];
    }
    
    
    // Dijkstras algorithm
    private int dijkstra(int source, int destination) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});
        
        Set<Integer> visited = new HashSet<>();
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            
            int node = current[0];
            int distance = current[1];
            
            if(visited.contains(node)) {
                continue;
            }
            
            visited.add(node);
            
            if(node == destination) {
                return distance;
            }
            
            Map<Integer, Integer> neighbors = graph.getOrDefault(node, new HashMap<>());
            
            for(Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                int nextNode = entry.getKey();
                int weight = entry.getValue();
                
                if(!visited.contains(nextNode)) {
                    int newDist = distance + weight;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }
        
        return MAX;
    }
    
}


