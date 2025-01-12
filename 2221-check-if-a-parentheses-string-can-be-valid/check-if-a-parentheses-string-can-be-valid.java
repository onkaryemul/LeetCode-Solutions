class Solution {

    // TC : O(2*n) ~ O(n)
    // SC : O(1)

    // Using two-pass solution ==> Greedy approach

    // 1st pass => left to right => for balancing the ')'
    // for balanced parenthesis string => (no. of wildcards on left + no. of '(') >= no. of ')' 
    // Violation condition:=> wildCard < (closing - opening)

    // 2nd pass => right to left => for balancing the '('
    // for balanced parenthesis string => (no. of wildcards on right + no. of ')') >= no. of '('
    // Violation condition:=> wildCard < (opening - closing) 

    public boolean canBeValid(String s, String locked) {
        int n = s.length(); // n == s.length == locked.length

        // Check if string length is odd
        if(n % 2 != 0) {
            return false; // odd length can't be balanced
        }

        // 1st pass => left to right
        int wildCard = 0;
        int opening = 0, closing = 0;

        for(int i=0; i < n; i++) {
            if(locked.charAt(i) == '0') {
               wildCard++;
            }
            else if(s.charAt(i) == '(') {
                opening++;
            }
            else { // s.charAt(i) == ')'
                closing++;
            }
            
            // Overbalanced ')' check
            if(wildCard < (closing - opening)) {
                return false;
            }
        }

        // 2nd pass => right to left
        wildCard = 0;
        opening = 0;
        closing = 0;

        for(int i = n-1; i >= 0; i--) {
            if(locked.charAt(i) == '0') {
                wildCard++;
            }
            else if(s.charAt(i) == '(') {
                opening++;
            }
            else { // s.charAt(i) == ")"
                closing++;
            }

            // Overbalanced '(' check
            if(wildCard < (opening - closing)) {
                return false;
            }
        }

        return true;
    }

}

