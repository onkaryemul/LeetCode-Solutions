class Solution {
    
    //T.C : O(nlogn)
    //S.C : O(n)
    
    // Greedy + Sorting
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        List<Integer> fayda = new ArrayList<>();
        long normalSum = 0;

        for (int num : nums) {
            fayda.add((num ^ k) - num);
            normalSum += (long) num;
        }

        Collections.sort(fayda, Collections.reverseOrder());

        for (int i = 0; i < fayda.size() - 1; i += 2) {
            long pairSum = fayda.get(i) + fayda.get(i + 1);

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        
        return normalSum;
    }
    
}

