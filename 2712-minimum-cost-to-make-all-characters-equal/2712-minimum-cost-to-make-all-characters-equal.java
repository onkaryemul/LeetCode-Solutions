class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Greedy Approach
    public long minimumCost(String s) {
        long minCost = 0; // minimum cost to make all characters of the binary string equal
        
        int n = s.length();
        for(int i=1; i < n; i++) {
            if(s.charAt(i) != s.charAt(i-1)) { // mismatch
                minCost += Math.min(i, n-i); // choose greedily
            }
        }
        
        return minCost;
    }   
     
}


/* 
At every mismatch (s[i] != s[i-1]), I have two options :
1. make previous chars same as current char (invert 0 to i-1) -> cost i
2. make current char same as previous chars (invert i to n-1) -> cost n-i

How to choose :--> based on cost whichever is lower i.e. min(i, n-i)

Note :--> We can choose greedily because whichever portion we invert, relationship between those elements will remain same.

For eg : if we invert i to n-1 (assume i to n-1 is 0011011)
if before invertings, there are x mismatch among them, after invert also it will remain same.
0011011 -> mismatch with previous at index 2,4 and 5 -> total 3 
1100100 -> mismatch with previous at index 2,4 and 5 -> total 3 at same positions
*/

