class Solution {
    
    // TC : O(n + 24*60) ~ O(n)
    // SC : O(24*60) ~ O(1)
    
    // Using "Count Sort"
    
    // function to return the "minimum" minutes difference between any two time-points in the list
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24*60];
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        // Mark time points and determine start & end time
        for(String time : timePoints) {
            int hours = Integer.parseInt(time.substring(0,2));
            int minutes = Integer.parseInt(time.substring(3,5));
            
            int totalMinutes = hours * 60 + minutes;
            
            // If the time is already recorded, then return 0
            if(times[totalMinutes]) {
                return 0;
            }
            
            times[totalMinutes] = true; // mark the time
            
            start = Math.min(start, totalMinutes);
            end = Math.max(end, totalMinutes);
        }
        
        // Calculate the minimum time difference by considering the circular nature of clock
        int minDifference = (24*60 - end) + start;
        int prev = start;
        
        // Iterate through the times to find the minimum difference
        for(int curr = start+1; curr <= end; curr++) {
            if(times[curr]) {
                minDifference = Math.min(minDifference, curr - prev);
                prev = curr;
            }
        }
        
        return minDifference;
    }
    
}

