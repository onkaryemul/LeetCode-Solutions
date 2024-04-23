class Solution {
    
    // BFS Traversal approach
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // find the level using BFS traversal
        List<Integer> res = new ArrayList<>();
        
        if(n <= 0) {
            return res;
        }
        
        if(n == 1) {
            res.add(0);
            return res;
        }
        
        // Construct the graph using adjacency list 
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n]; // for storing degree of each node
        
        for(int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            
            map.putIfAbsent(edge[0], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }
        
        
        // Apply BFS Traversal technique using queue
        Queue<Integer> leaves = new LinkedList<>();
        
        for(int i=0; i < n; i++) {
            if(degree[i] == 1) {
                leaves.offer(i); // add in queue
            }
        }
        
        int count = n; // Initially graph has n nodes
        
        while(count > 2) {
            int size = leaves.size();
            
            count = count - size; // reduce the size of graph at each level 
            
            while(size-- > 0) {
                Integer leaf = leaves.poll();
                for(Integer connection : map.get(leaf)) {
                    degree[connection]--;
                    map.get(connection).remove(leaf); // optional
                    if(degree[connection] == 1) {
                        leaves.offer(connection);
                    }
                }
            }
        }
        
        return new ArrayList<>(leaves);
    }
    
}

