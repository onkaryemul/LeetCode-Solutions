class Solution {
    
    // T.C : O(n * logn, After memoizing, we will visit at max n states and for binarysearch it will take log(n))
    
    // S.C : O(n*3) ~= O(n)

    // Recursion + Memoization and Sorting
    
    private int n;
    private int[][] dp = new int[100001][3];
    

    public int maxTwoEvents(int[][] events) {
        n = events.length;
        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // Sort events by start time
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(events, 0, 0);
    }
    
    
    private int solve(int[][] events, int i, int count) {
        if (count == 2 || i >= n) {
            return 0;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int nextValidEventIndex = binarySearch(events, events[i][1]);
        
        int take = events[i][2] + solve(events, nextValidEventIndex, count + 1);
        
        int notTake = solve(events, i + 1, count);
        
        return dp[i][count] = Math.max(take, notTake);
    }
    
    
    // Binary search for the next event start time greater than the current event's end time
    private int binarySearch(int[][] events, int endTime) {
        int left = 0, right = n - 1, result = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (events[mid][0] > endTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
}

