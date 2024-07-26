class Solution {
    
    // TC : O(n*logn + n)
    // SC : O(n^2, for returning two dimensional arraylist 
    
    public int[][] merge(int[][] intervals) {
        int n = intervals.length; // size of array
        
        // Sort the given intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        List<List<Integer>> ans = new ArrayList<>(); // tracks non-overlapping intervals
        
        for(int i=0; i < n; i++) {
            // If the current interval does not lie in the last interval
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(intervals[i][0]);
                newInterval.add(intervals[i][1]);
                
                ans.add(newInterval);
            }
            // If the current interval lies in the last interval
            else {
                List<Integer> prevInterval = ans.get(ans.size() - 1);
                prevInterval.set(1, Math.max(prevInterval.get(1), intervals[i][1]));
            }
        }
        
        int size = ans.size();
        int[][] nonOverlappingIntervals = new int[size][2];
                                 
        for(int i=0; i < size; i++) {
            for(int j=0; j < 2; j++) {
                nonOverlappingIntervals[i][j] = ans.get(i).get(j);
            }
        }
        
        return nonOverlappingIntervals;
    }
    
}

