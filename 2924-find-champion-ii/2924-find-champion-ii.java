class Solution {
    
    //Approach - Simple indegree check
    
    //T.C : O(m + n)
    //S.C : O(n)

    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        // Calculate indegree for each node
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // u --> v
            indegree[v]++;
        }

        int champ = -1;
        int count = 0;

        // Check for the champion node
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { // ith node is the champion
                champ = i;
                count++;
                if (count > 1) {
                    return -1; // More than one node with indegree 0, no champion
                }
            }
        }

        return champ;
    }
    
}

