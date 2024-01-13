//T.C : O(n^3)  -> because of nested for loop 26*26*26
//S.C : O(1) -> We take distances matrix of 26*26 which is constant

class Solution {
    
    // helper function 
    private void floydWarshall(long[][] distanceMatrix, char[] original, char[] changed, int[] cost) {
        int len = original.length;
        
        for(int i=0; i<len; i++) {
            int sourceIdx = original[i] - 'a';
            int targetIdx = changed[i] - 'a';
            distanceMatrix[sourceIdx][targetIdx] = Math.min(distanceMatrix[sourceIdx][targetIdx], (long)cost[i]);
        }
        
        // O(n^3) -> nested for loops
        for(int k=0; k<26; k++) { // intermediate vertices
            for(int i=0; i<26; i++) {
                for(int j=0; j<26; j++) {
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
                }
            }
        }
    }
    
    
    
    //Approach-1 (Using Simple Floyd Warshall Algorithm)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0; // store the minimum cost to convert the string source to the string target
        
        long[][] distanceMatrix = new long[26][26];
        for(int i=0; i<26; i++) {
            Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE);
        }
        
        floydWarshall(distanceMatrix, original, changed, cost);
        
        int len = source.length();
        for(int i=0; i<len; i++) {
            char sourceChar = source.charAt(i);
            char targetChar = target.charAt(i);
            
            if( sourceChar == targetChar ) {
                continue;
            }
            
            // If it is impossible to convert source to target, return -1.
            if(distanceMatrix[sourceChar-'a'][targetChar-'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += distanceMatrix[sourceChar-'a'][targetChar-'a'];
            }
        }
        
        
        return ans;
    }
    
}


