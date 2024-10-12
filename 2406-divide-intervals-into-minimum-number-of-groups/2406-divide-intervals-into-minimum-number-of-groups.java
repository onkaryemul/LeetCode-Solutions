class Solution {
    
    // TC : O(n*logn)
    // SC : O(n)
    
    // Using Line Sweep Algorithm
    
    // Using TreeMap => to store start or end & its frequency
    
    // Similar to Meeting problem
    // key : startTime, value : +1
    // key : endTime, value : -1
    
    // TreeMap => entries are sorted based on key (ie. based on the increasing order of key)
    public int minGroups(int[][] intervals) {
        int n = intervals.length; // no. of intervals
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1] + 1; // since, end is also inclusive
            
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        
        int maxCnt = 0; // maximum overlapping intervals at a given time
        int currCnt = 0; // current running intervals cnt
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            currCnt = currCnt + entry.getValue(); // no. of events starting or ending at that time
            maxCnt = Math.max(maxCnt, currCnt);
        }
        
        // return maxCnt => indicating maximum overlapping intervals at a given time
        // => refering that these many minimum groups need to be make
        return maxCnt; 
    }
    
}

