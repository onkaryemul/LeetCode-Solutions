class Tuple {
    double prob;
    int node;
    
    public Tuple(double prob, int node) {
        this.prob = prob;
        this.node = node;
    }
    
    public static class TupleComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple t1, Tuple t2) {
            return Double.compare(t2.prob, t1.prob);
        }
    }
}


class Solution {
    
    // TC : O(E + V*logE)
    // SC : O(V + E)
    
    // Using the concept of "Dijkstra's algorithm"
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>(new Tuple.TupleComparator());
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        Map<Integer, List<Tuple>> graph = new HashMap<>();
        for(int i=0; i < edges.length; i++) {
            int[] edge = edges[i];
            
            int x = edge[0];
            int y = edge[1];
            
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new Tuple(succProb[i], y));
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new Tuple(succProb[i], x));
        }
        
        heap.add(new Tuple(1, start_node));
        
        while(!heap.isEmpty()) {
            Tuple curr = heap.poll();
            
            if(curr.node == end_node) {
                return curr.prob;
            }
            
            if(visited[curr.node]) {
                continue;
            }
            
            visited[curr.node] = true;
            
            if(graph.containsKey(curr.node)) {
                for(Tuple child : graph.get(curr.node)) {
                    if(!visited[child.node]) {
                        heap.add(new Tuple(curr.prob * child.prob, child.node));
                    }
                }
            }
        }
    
        return 0;
    }
    
}

