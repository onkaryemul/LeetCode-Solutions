class Solution {
    
    // n = no. of flowers 
    // max_d = highest value in the array bloomDay
    
    
    // TC : O(n * log(max_d)) 
    // SC : O(1)
    
    
    // Binary Search Technique on "Answer"
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        // Base case 
        // Check if it is impossible to get m bouquets
        if(n < m*k) {
            return -1;
        }
        
        int startDay = 1;
        int endDay = Arrays.stream(bloomDay).max().getAsInt();
        
        int minDays = -1;
        
        while(startDay <= endDay) {
            int mid = startDay + (endDay - startDay)/2;
            
            if(getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                endDay = mid - 1;
            }
            else {
                startDay = mid + 1;
            }
        }
        
        return minDays;
    }
    
    
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int consecutiveCnt = 0;
        
        // Find count of consecutive flowers you can pick at mid day
        for(int i=0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                consecutiveCnt++;
            }
            else {
                consecutiveCnt = 0;
            }
            
            if(consecutiveCnt == k) {
                numOfBouquets++;
                consecutiveCnt = 0;
            }
        }
        
        return numOfBouquets;
    }
    
}

