class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Topological Sort - BFS Approach
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> fromTo = new HashMap<>();
        
        HashMap<Integer, List<Integer>> toFrom = new HashMap<>();
        
        HashMap<Integer, Integer> degree = new HashMap<>(); // for storing the indegree of each node
        
        // Populate fromTo, toFrom and degree from given input edges
        for(int[] edge : edges) {
            toFrom.putIfAbsent(edge[1], new ArrayList<>());
            toFrom.get(edge[1]).add(edge[0]);
            
            fromTo.putIfAbsent(edge[0], new ArrayList<>());
            fromTo.get(edge[0]).add(edge[1]);
            
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
        }
        
        HashMap<Integer, Set<Integer>> ancestors = new HashMap<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i < n; i++) {
            // if the node's degree is zero, we can add it to the queue for BFS
            if(degree.getOrDefault(i, 0) == 0) {
                queue.add(i);
            }
        }
        
        // BFS Starts
        while(!queue.isEmpty()) {
            int u = queue.poll();
            
            Set<Integer> result = new HashSet<>();
            
            for(int ancestor : toFrom.getOrDefault(u, new ArrayList<>())) {
                result.add(ancestor);
                result.addAll(ancestors.getOrDefault(ancestor, new HashSet<>()));
            }
            
            ancestors.put(u, result);
            
            for(int v : fromTo.getOrDefault(u, new ArrayList<>())) {
                degree.put(v, degree.get(v) - 1);
                if(degree.get(v) == 0) {
                    queue.add(v);
                }
            }
        }
        
        // As the output needs to be given in sorted order, we will sort the ancestors list
        List<List<Integer>> sortedResults = new ArrayList<>(n);
        
        for(int i=0; i < n; i++) {
            Set<Integer> result = ancestors.get(i);
            
            List<Integer> sorted = new ArrayList<>(result);
            Collections.sort(sorted);
            
            sortedResults.add(sorted);
        }
        
        return sortedResults;
    }
    
}

