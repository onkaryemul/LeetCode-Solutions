class Solution {
    
    // TC : O(k^2 + n)
    // SC : O(k^2 + n)
    
    // Topological Sorting using DFS
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> orderRows = topoSort(rowConditions, k);
        List<Integer> orderColumns = topoSort(colConditions, k);
        
        // Base case
        // We might have found cycle, that's why topo order is empty
        if(orderRows.isEmpty() || orderColumns.isEmpty()) {
            return new int[][]{};
        }
        
        int[][] matrix = new int[k][k];
        
        Map<Integer, Integer> positionMap = new HashMap<>();
        for(int i=0; i < k; i++) {
            positionMap.put(orderColumns.get(i), i);
        }
        
        for(int i=0; i < k; i++) {
            int element = orderRows.get(i);
            if(positionMap.containsKey(element)) {
                matrix[i][positionMap.get(element)] = element;
            }
        }
        
        return matrix;
    }
    
    
    private List<Integer> topoSort(int[][] edges, int n) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();
        
        // 0 : not visited
        // 1 : visiting
        // 2 : visited
        int[] visited = new int[n+1]; 
        
        boolean[] hasCycle = {false};
        
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        
        for(int i=1; i <= n; i++) {
            if(visited[i] == 0) {
                dfs(i, adj, visited, stack, hasCycle);
                if(hasCycle[0]) {
                    return new ArrayList<>(); // no ordering possible
                }
            }
        }
        
        while(!stack.isEmpty()) {
            order.add(stack.pop());
        }
        
        return order;
    }
    
    
    private void dfs(int node, Map<Integer, List<Integer>> adj, int[] visited, Stack<Integer> stack, boolean[] hasCycle) {
        // Mark node as visiting
        visited[node] = 1;
        
        for(int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if(visited[neighbor] == 0) {
                dfs(neighbor, adj, visited, stack, hasCycle);
            }
            else if (visited[neighbor] == 1) {
                hasCycle[0] = true; // cycle detected
                return;
            }
        }
        
        visited[node] = 2; // mark node as visited
        
        stack.push(node); // add node to the stack
    }
    
}

