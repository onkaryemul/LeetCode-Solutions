class Solution {
    
    // TC : O(n^2)
    // SC : O(1)
    
    // Simplest Approach --> Counting left and right values
    public int numTeams(int[] rating) {
        int n = rating.length;
        
        int teams = 0;
        
        for(int j=1; j < n-1; j++) {
            int countSmallerLeft = 0;
            int countLargerLeft = 0;
            int countSmallerRight = 0;
            int countLargerRight = 0;
            
            // Calculate count of smaller & larger left
            for(int i=0; i < j; i++) {
                if(rating[i] < rating[j]) {
                    countSmallerLeft++;
                }
                else if (rating[i] > rating[j]) {
                    countLargerLeft++;
                }
            }
            
            // Calculate the count of smaller & larger right
            for(int k=j+1; k < n; k++) {
                if(rating[j] < rating[k]) {
                    countLargerRight++;
                }
                else if (rating[j] > rating[k]) {
                    countSmallerRight++;
                }
            }
            
            teams += (countSmallerLeft * countLargerRight) + (countLargerLeft * countSmallerRight);
        }
        
        return teams;
    }
    
}

