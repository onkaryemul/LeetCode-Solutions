class Solution {
    
    // T.C : O(n)
    // S.C : O(m)

    // Approach - Simple Greedily select smallest numbers
    
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : banned) {
            set.add(num);
        }

        int count = 0;
        int sum = 0;

        for (int num = 1; num <= n; num++) {
            if (set.contains(num)) {
                continue;
            }

            if (sum + num <= maxSum) {
                count++;
                sum += num;
            } else {
                break;
            }
        }

        return count;
    }
    
}

