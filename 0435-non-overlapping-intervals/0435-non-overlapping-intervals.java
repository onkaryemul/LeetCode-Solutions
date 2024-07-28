class Solution {
    
    // TC : O(n*logn)
    // SC : O(1)
    
    // Greedy Approach
    // Similar to N meetings in one room
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. Sort the intervals array based on end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int n = intervals.length; // no. of intervals
        int end = intervals[0][1]; // end time of 0th interval
        
        int selectedCnt = 1; // First interval is always selected
        
        for(int i=1; i < n; i++) {
            // If starting time of current interval > prev end time, then select this interval and update end time  
            if(intervals[i][0] >= end) {
                selectedCnt++; // select this interval 
                end = intervals[i][1]; 
            }
        }
        
        return n - selectedCnt; // gives minimum no. of intervals which we need to remove to make the rest of the intervals non-overlapping 
    }
        
}

