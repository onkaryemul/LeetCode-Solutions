class Solution {
    
    // TC : O(n + 26*26*26) ~ O(n), due to nested for loops 26*26*26
    // SC : O(26*26) ~ O(1), we take distance matrix of 26*26 which is constant
    
    // Using Floyd Warshall Algorithm
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long minCost = 0; // store the minimum cost to convert the source string to the target string
        
        long[][] distanceMatrix = new long[26][26];
        for(int i=0; i < 26; i++) {
            Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE);
        }
        
        floydWarshall(distanceMatrix, original, changed, cost);
        
        int len = source.length(); 
        for(int i=0; i < len; i++) {
            char srcChar = source.charAt(i);
            char targetChar = target.charAt(i);
            
            if(srcChar == targetChar) {
                continue;
            }
            
            // Check if it is impossible to convert source string to target string, then return -1
            if(distanceMatrix[srcChar - 'a'][targetChar - 'a'] == Integer.MAX_VALUE) {
                return -1;
            }
            
            minCost = minCost + distanceMatrix[srcChar - 'a'][targetChar - 'a'];
        }
        
        return minCost;
    }
    
    
    private void floydWarshall(long[][] distanceMatrix, char[] original, char[] changed, int[] cost) {
        int n = original.length; // = changed.length  or cost.length
        
        // Populate the distance matrix with values of cost[i] from original[i] to changed[i]
        for(int i=0; i < n; i++) {
            int srcIdx = original[i] - 'a';
            int targetIdx = changed[i] - 'a';
            
            distanceMatrix[srcIdx][targetIdx] = Math.min(distanceMatrix[srcIdx][targetIdx], (long)cost[i]);
        }
        
        // Perform Floyd Warshall's algorithm to find shortest path of visited one node from other node in O(1) time complexity
        // O(26*26*26) -> nested for loops
        for(int k=0; k < 26; k++) { // intermediate vertices
            for(int i=0; i < 26; i++) {
                for(int j=0; j < 26; j++) {
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
                }
            }
        }
        
    }
    
}
