class Solution {
    
    // TC : O(n)
    // SC : O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        
        int i = 0;
        
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Modifying  newInterval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        result.add(newInterval); // adding new Interval into the result
        
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
}

