class Solution {
    
    // TC : O(n + m)
    // SC : O(n + m)
    
    // Using Greedy approach ==> to find length of longest diameter of undirected tree
    
    // Using DFS traversal 
    
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> t1 = buildTree(n, edges1);
        int d1 = getDiameter(t1, n);
        
        List<List<Integer>> t2 = buildTree(m, edges2);
        int d2 = getDiameter(t2, m);
        
        int minDiameter = 1 + (d1 + 1) / 2 + (d2 + 1) / 2;

        return Math.max(d1, Math.max(d2, minDiameter));
    }

                        
    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        return tree;
    }

                        
    private int getDiameter(List<List<Integer>> tree, int n) {
        int[] firstDFS = dfs(tree, 0, -1);
        int[] secondDFS = dfs(tree, firstDFS[0], -1);
        return secondDFS[1];
    }

                        
    private int[] dfs(List<List<Integer>> tree, int node, int parent) {
        int farthestNode = node;
        int maxDistance = 0;

        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) 
                continue;
            
            int[] result = dfs(tree, neighbor, node);
            
            if (result[1] + 1 > maxDistance) {
                maxDistance = result[1] + 1;
                farthestNode = result[0];
            }
        }

        return new int[] { farthestNode, maxDistance };
    }
    
}


/*  
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dia1 = findDiameter(edges1);
        int dia2 = findDiameter(edges2);
        
        int radius1 = (dia1 + 1) / 2;
        int radius2 = (dia2 + 1) / 2;
        
        int sum = 1 + radius1 + radius2;
        
        return Math.max(sum, Math.max(dia1, dia2));
    }
    
    
    // Helper function ==> to find the diameter 
    private int findDiameter(int[][] edges) {
        if(edges == null || edges.length == 0) {
            return 0;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        Set<Integer> nodes = new HashSet<>();
        
        // Build the adjacency list
        for(int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        
        return diameter(adj, nodes.size());
    }
    
    
    // Helper function ==> to calculate the length of longest diamter of tree using BFS
    private int diameter(Map<Integer, List<Integer>> adj, int n) {
        // first, apply BFS to find the farthest node
        int farthestNode = bfs(0, adj, n);
        
        // secondly, apply BFS from the farthest node to calculate the diameter
        return bfs(farthestNode, adj, n) - 1;
    }
    
    // Helper function => BFS(level order) traversal
    private int bfs(int start, Map<Integer, List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        
        int level = 0;
        int lastNode = start;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i < size; i++) {
                int curr = queue.poll();
                
                lastNode = curr;
                
                for(int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            
            level++;
        }
        
        return lastNode == start ? 1 : level;
    }
*/

