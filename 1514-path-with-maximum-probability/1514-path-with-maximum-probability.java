class Solution {
    
    // Using Dijkstra's Algorithm
    
    // TC : O(V + E*logV)
    // SC : O(V + E)
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Build the graph
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        
        for(int i=0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            double pathProb = succProb[i];
            
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }
        
        // Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1d; 
        
        // Max-heap priority queue to explore the highest probability first
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> - Double.compare(a.getKey(), b.getKey()));
        
        pq.add(new Pair<>(1.0, start));
        
        
        while(!pq.isEmpty()) {
            Pair<Double, Integer> curr = pq.poll();
            double currProb = curr.getKey();
            int currNode = curr.getValue();
            
            // If the current node is the end node, then return the probability
            if(currNode == end) {
                return currProb;
            }
            
            // Explore the neighbors
            for(Pair<Integer, Double> nbr : graph.getOrDefault(currNode, new ArrayList<>())) {
                int nbrNode = nbr.getKey();
                double pathProb = nbr.getValue();
                
                // Update the probability if a higher one is found
                if(currProb * pathProb > maxProb[nbrNode]) {
                    maxProb[nbrNode] = currProb * pathProb;
                    pq.add(new Pair<>(maxProb[nbrNode], nbrNode));
                }
            }
        }
        
        // If the end node is not reachable, then return 0
        return 0d;
    }
    
}

