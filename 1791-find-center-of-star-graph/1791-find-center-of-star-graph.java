class Solution {
    
    // TC : O(n)
    // SC : O(n)
    
    // Using HashMap
    public int findCenter(int[][] edges) {
        int n = edges.length;
        
        HashMap<Integer, Integer> degreeMap = new HashMap<Integer, Integer>();
        
        for(int[] edge : edges) {
            degreeMap.put(edge[0], degreeMap.getOrDefault(edge[0], 0) + 1);
            degreeMap.put(edge[1], degreeMap.getOrDefault(edge[1], 0) + 1);
        }
        
        for(int node : degreeMap.keySet()) {
            if(degreeMap.get(node) == n) {
                return node;
            }
        }
        
        return -1;
    }
    
}

