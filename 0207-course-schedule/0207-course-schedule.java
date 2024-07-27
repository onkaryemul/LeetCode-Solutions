class Solution {

    // Using BFS Cycle Check - kahn's Algorithm (Topological Sort)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            
            if(!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            
            adj.get(b).add(a);
            
            indegree[a]++;
        }
        
        return topologicalSortCheck(adj, numCourses, indegree);
    }
    
    
    private boolean topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for(int i=0; i < n; i++) {
            if(indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int u = queue.poll();
            
            if(adj.containsKey(u)) {
                for(int v : adj.get(u)) {
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        count++;
                        queue.offer(v);
                    }
                }
            }
        }
        
        if(count == n) { // we can finish all courses, hence return true
            return true;
        }
        
        return false; // we cannot finish all the courses, hence return false
    }
    
}

