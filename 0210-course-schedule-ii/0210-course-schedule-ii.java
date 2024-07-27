class Solution {
    
    // Using BFS Topological Sort concept
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        // Create an array to keep track of the indegree of each node
        int[] indegree = new int[numCourses];
        
        // Fill the adjacency list and in-degree array based on the prerequisites
        for(int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            
            // b --> a
            adj.get(b).add(a);
            
            // Increment the indegree of 'a'
            indegree[a]++;
        }
        
        // Use kahn's algorithm to fnd the topological sort
        return topologicalSort(adj, numCourses, indegree);
    }
    
    
    private int[] topologicalSort(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] result = new int[n];
        
        int index = 0;
        
        // Add nodes with indegree 0 to the queue
        for(int i=0; i < n; i++) {
            if(indegree[i] == 0) {
                result[index] = i;
                index++;
                count++;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            
            // Decrease the indegree of adjacent nodes
            for(int v : adj.get(u)) {
                indegree[v]--;
                
                // If indegree becomes 0, then add it to the result and the queue
                if(indegree[v] == 0) {
                    result[index] = v;
                    index++;
                    count++;
                    queue.offer(v);
                }
            }   
        }
        
        if(count == n) { // we can finish all courses, then return their order 
            return result;
        }
        
        return new int[0]; // we cannot finish all courses due to cycle, then return an empty array
    }
    
}

