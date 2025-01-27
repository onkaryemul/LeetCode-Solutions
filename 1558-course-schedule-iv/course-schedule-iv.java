class Solution {
    
    // Using Kahn's Algorithm

    // T.C : O(V^2 + V + E) -> Processing Nodes (each node pushed once in queue) = O(V), Processing edges = O(E), Inserting prerequisites (each node can have ~V prerequisites in worst case): O(V^2)
    // S.C : O(V+E)

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list and indegree array
        Map<Integer, List<Integer>> adj = new HashMap<>();

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            
            indegree[v]++;
        }

        // Initialize queue with nodes having indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Map from node to set of prerequisite nodes
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                // Add current node and its prerequisites to the neighbor's prerequisites
                prereqMap.computeIfAbsent(neighbor, k -> new HashSet<>()).add(node);
                
                prereqMap.get(neighbor).addAll(prereqMap.getOrDefault(node, new HashSet<>()));

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Process each query
        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            
            result.add(prereqMap.getOrDefault(dest, new HashSet<>()).contains(src));
        }

        return result;
    }

}


/*   
// Approach-1 (Using DFS) - You can use BFS as well
// T.C : O(Q * (V+E))
// S.C : O(V+E)

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list representation of the graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v); // u --> v
        }

        int Q = queries.length; // Number of queries
        List<Boolean> result = new ArrayList<>(Q);

        // Process each query
        for (int i = 0; i < Q; i++) {
            int u = queries[i][0]; // Source
            int v = queries[i][1]; // Destination

            // Initialize visited array for DFS
            boolean[] visited = new boolean[numCourses];
            result.add(dfs(adj, u, v, visited)); // You can use BFS as well
        }

        return result;
    }

    // Perform DFS to check if there is a path from src to dest
    private boolean dfs(Map<Integer, List<Integer>> adj, int src, int dest, boolean[] visited) {
        visited[src] = true;

        if (src == dest) {
            return true; // Yes, we can reach the destination
        }

        boolean isReachable = false;
        for (int adjNode : adj.getOrDefault(src, new ArrayList<>())) {
            if (!visited[adjNode]) {
                isReachable = isReachable || dfs(adj, adjNode, dest, visited);
            }
        }

        return isReachable;
    }

//Approach-2 (Using preprocessing and DFS) - You can use BFS as well
//T.C : O(V^2 * (V+E))
//S.C : O(V+E)

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list representation of the graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        // Preprocess to determine prerequisites
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, adjList, isPrerequisite);

        // Process each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }

    // Preprocess to mark prerequisites for each node
    private void preprocess(int numCourses, Map<Integer, List<Integer>> adjList, boolean[][] isPrerequisite) {
        for (int u = 0; u < numCourses; u++) {
            for (int v = 0; v < numCourses; v++) {
                if (u != v) {
                    boolean[] visited = new boolean[numCourses];
                    if (dfs(adjList, visited, u, v)) {
                        isPrerequisite[u][v] = true;
                    }
                }
            }
        }
    }

    // Perform DFS to check if src is a prerequisite of target
    private boolean dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int src, int target) {
        visited[src] = true;

        if (src == target) {
            return true;
        }

        for (int adjNode : adjList.getOrDefault(src, new ArrayList<>())) {
            if (!visited[adjNode] && dfs(adjList, visited, adjNode, target)) {
                return true;
            }
        }

        return false;
    }
*/

