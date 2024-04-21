class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        
        return dfs(graph, visited, source, destination);
    }
    
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int curr, int end) {
        // Base case
        if(curr == end) {
            return true;
        }
        
        if(visited[curr]) {
            return false;
        }
        
        visited[curr] = true;
        
        for(int i=0; i < graph.get(curr).size(); i++) {
            if(dfs(graph, visited, graph.get(curr).get(i), end)) {
                return true;
            }
        }
        
        return false;
    }
    
}

