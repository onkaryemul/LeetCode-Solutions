class Solution {
    
    // TC : O(n)
    // SC : O(1)
    
    // Using Greedy approach
    
    // 1 => represent black balls
    // 0 => represent white balls
    public long minimumSteps(String s) {
        int n = s.length();
        
        long swaps = 0;
        
        // Straight forward traversal
        int black = 0;
        
        // We want all the white balls (0) to the left & all the black balls (1) to the right
        // count black balls(1) while traversing, but when white balls(0) appears, we need to place it to the left => we need to check how many black balls (1) are there to its left => so that, that many adjacent swaps need to be preformed
        
        for(int i=0; i < n; i++) {
            int ch = s.charAt(i);
            
            if(ch == '0') { // move white to the left
                swaps += black;
            }
            else { // ch == '1', since string s => binary string
                black++;
            }
        }
        
        return swaps;
    }
    
}


/*
//Approach-2 (Reversed traversal)
//T.C : O(n)
//S.C : O(1)

    public long minimumSteps(String s) {
        int n = s.length();
        long swaps = 0;
        int white = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {  // Move black to the right
                swaps += white;
            } else {  // If it's white ('0'), increment white count
                white++;
            }
        }

        return swaps;
    }
*/

