class Solution {
    
    // TC : O(2^n)
    // SC : O(n)
    
    // Using Recursion + Backtracking approach
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Using Sorting & filtering technique --> To avoid duplicate combinations in the result list
        Arrays.sort(candidates); // Sort to handle duplicates
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(); // temporary list to store elements of a combination
        
        solve(0, target, curr, candidates, result);
        
        return result;
    }
    
    
    
    private void solve(int idx, int target, List<Integer> curr, int[] candidates, List<List<Integer>> result) {
        // Edge case/Corner case :-->  If target < 0, then return
        if(target < 0) {
            return;
        }
        
        // Base case : If target == 0, then we found one new combination which we add in the result list
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        // Traverse from idx till last
        for(int i=idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i-1]) {
                // To avoid duplicate combinations in the result list
                continue; // Ignore duplicate elements
            }
            
            curr.add(candidates[i]); // DO -> add current element in curr list
            solve(i+1, target-candidates[i], curr, candidates, result); // EXPLORE
            curr.remove(curr.size()-1); // UNDO
        }
    }
    
}

